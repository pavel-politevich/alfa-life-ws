package by.lifetech.alfalife.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StatementResponse{
	@JsonProperty("page")
	public ArrayList<Error> errors;
	
	@JsonProperty("page")
    public ArrayList<Statistics> statistics;
	
	@JsonProperty("page")
    public int totalRowCount;
	
	@JsonProperty("page")
    public String cacheKey;
	
    @JsonProperty("page")
    public ArrayList<Statement> page;
}
