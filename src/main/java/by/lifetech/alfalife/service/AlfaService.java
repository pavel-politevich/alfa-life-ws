package by.lifetech.alfalife.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import by.lifetech.alfalife.model.Page;
import by.lifetech.alfalife.model.Root;

@Service
public class AlfaService {

	@Value("${alfa.statement.url}")
	private String url;
	@Value("${alfa.oauth2.client.grantType}")
	private String grantType;
	@Value("${alfa.oauth2.client.clientId}")
	private String clientId;
	@Value("${alfa.oauth2.client.clientSecret}")
	private String clientSecret;
	@Value("${alfa.oauth2.client.accessTokenUri}")
	private String accessTokenUri;
	@Value("${alfa.oauth2.client.scope}")
	private String scope;
	@Value("${alfa.oauth2.client.username}")
	private String username;
	@Value("${alfa.statement.pageRowCount}")
	private String pageRowCount;
	@Value("${alfa.statement.transactions}")
	private String transactions;
	@Value("${alfa.statement.pageNo}")
	private String pageNo;
	
	@Value("${alfa.client.account}")
	private String accNumber;

	@Value("${ftp1.username}")
	private String ftpUserName;
	@Value("${ftp1.password}")
	private String ftpPassword;
	@Value("${ftp1.host}")
	private String ftpHostName;
	@Value("${ftp1.folder}")
	private String ftpPath;
	@Value("${ftp1.filename.prefix}")
	private String prefixFile;
	@Value("${ftp1.filename.extension}")
	private String extensionFile;

	Logger logger = LoggerFactory.getLogger(AlfaService.class);

	RestTemplate restTemplate = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	private static ObjectMapper mapper = new ObjectMapper();
	String token = "";

	public Root getStatement(String dateFrom, String dateTo, String accessToken) {

		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.set("Authorization", "Bearer " + accessToken);
		HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url + accNumber + "/statement/")
		        .queryParam("dateFrom", dateFrom)
		        .queryParam("dateTo", dateTo)
				.queryParam("pageNo", pageNo)
				.queryParam("pageRowCount", pageRowCount)
				.queryParam("transactions", transactions);
		
		logger.info("URI = [" + builder.buildAndExpand().toUri() + "]");

		ResponseEntity<Root> responseEntity = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET,
				requestEntity, Root.class);
		
		Root st = responseEntity.getBody();
		logger.debug("Response body = [" + responseEntity.getBody() + "]");

		return st;

	}

	public String getToken() throws JsonMappingException, JsonProcessingException {
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("grant_type", grantType);
		map.add("username", username);
		map.add("client_id", clientId);
		map.add("client_secret", clientSecret);
		map.add("scope", scope);

		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(accessTokenUri, entity, String.class);
		logger.debug("Response body = [" + responseEntity.getBody().toString() + "]");

		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			JsonNode rootNode = mapper.readTree(responseEntity.getBody());
			JsonNode locatedNode = rootNode.path("access_token");
			token = locatedNode.asText();
			logger.info("Access_token = [" + token + "]");
		} else
			logger.error("Can not get Access_token");
		return token;
	}

	public String StatementToFile(Root statementRoot) throws IOException {

		String fileName = getFileName();
		File myFile = new File(fileName);
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(myFile.getAbsolutePath()), "CP866"));

		for (Page p : statementRoot.getPage()) {
			writer.append(p.toFileFormat());
			writer.append("\n");
		}

		writer.close();
		return fileName;
	}

	public String getFileName() {
		String fileName = prefixFile;
		SimpleDateFormat sdf = new SimpleDateFormat("ddMM");
		Calendar c = Calendar.getInstance();
		Date now = new Date();
		c.setTime(now);
		fileName = fileName + sdf.format(c.getTime()) + extensionFile;
		logger.info("File name: " + fileName);
		return fileName;
	}

	public void uploadToFtp(String fileName) {
		FTPClient client = new FTPClient();
		File initialFile = new File(fileName);

		try (InputStream is = new FileInputStream(initialFile)) {
			client.connect(ftpHostName);
			boolean login = client.login(ftpUserName, ftpPassword);
			if (login) {
				logger.info("Login to FTP success...");
				client.enterLocalPassiveMode();
				client.setFileType(FTP.ASCII_FILE_TYPE);
				client.changeWorkingDirectory(ftpPath);
				client.storeFile(fileName, is);
				client.logout();
				logger.info("File " + fileName + " stored to " + ftpPath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				client.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		initialFile.delete();
		logger.debug("File " + fileName + " deleted from local folder.");
	}

}
