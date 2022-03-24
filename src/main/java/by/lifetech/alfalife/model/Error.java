package by.lifetech.alfalife.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Error{
	@JsonProperty("number")
    public String getNumber() {
		return number;
	}
	@JsonProperty("message")
	public String getMessage() {
		return message;
	}
	String number;
    String message;
}
