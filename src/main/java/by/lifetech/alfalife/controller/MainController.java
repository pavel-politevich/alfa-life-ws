package by.lifetech.alfalife.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import by.lifetech.alfalife.controller.exception.ControllerRuntimeException;
import by.lifetech.alfalife.model.Root;
import by.lifetech.alfalife.service.AlfaService;


@RestController
@EnableScheduling
public class MainController {
	
	private final AlfaService alfaService;
	private String fileName;
	Logger logger = LoggerFactory.getLogger(MainController.class);

	public MainController(AlfaService alfaService) {
		super();
		this.alfaService = alfaService;
	}
	
	// Every day at 09:00 for yesterday's operations
	@Scheduled(cron = "0 0 9 * * ?")
	void executeAuto() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar c = java.util.Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		c.setTime(new Date());
		logger.info("Call executeAuto method at Cron");
		execute(sdf.format(c.getTime()), sdf.format(c.getTime()));
	}
	
	
	@GetMapping("/execute")
	Root execute(@RequestParam String dateFrom, @RequestParam String dateTo) {
		logger.info("Call execute method with dateFrom = " + dateFrom + " and dateTo = " + dateTo);
		try {
			Root rt = alfaService.getStatement(dateFrom,dateTo, alfaService.getToken());
			fileName = alfaService.StatementToFile(rt);
			alfaService.uploadToFtp(fileName);
			return rt;
		} catch (JsonMappingException e) {
			logger.error("JSON parse exception while get token");
			throw new ControllerRuntimeException(e);
		} catch (JsonProcessingException e) {
			logger.error("JSON parse exception while get token");
			throw new ControllerRuntimeException(e);
		} catch (IOException e) {
			logger.error("Failed to find or create file");
			throw new ControllerRuntimeException(e);
		}
	}
	
	
	@GetMapping("/token")
	String test() {
		try {
			return alfaService.getToken();
		} catch (JsonMappingException e) {
			logger.error("JSON parse exception while get token");
			throw new ControllerRuntimeException(e);
		} catch (JsonProcessingException e) {
			logger.error("JSON parse exception while get token");
			throw new ControllerRuntimeException(e);
		}
		
	}
	
	@GetMapping("/ftp")
	String testFtp(@RequestParam String fileName) {
		alfaService.uploadToFtp(fileName);
		return "Success";
				
	}
}
