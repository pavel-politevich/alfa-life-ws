package by.lifetech.alfalife.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistics {
	@JsonProperty("number")
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	String number;

	@JsonProperty("openingBalance")
	public double getOpeningBalance() {
		return this.openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	double openingBalance;

	@JsonProperty("openingBalanceEq")
	public double getOpeningBalanceEq() {
		return this.openingBalanceEq;
	}

	public void setOpeningBalanceEq(double openingBalanceEq) {
		this.openingBalanceEq = openingBalanceEq;
	}

	double openingBalanceEq;

	@JsonProperty("closingBalance")
	public double getClosingBalance() {
		return this.closingBalance;
	}

	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}

	double closingBalance;

	@JsonProperty("closingBalanceEq")
	public double getClosingBalanceEq() {
		return this.closingBalanceEq;
	}

	public void setClosingBalanceEq(double closingBalanceEq) {
		this.closingBalanceEq = closingBalanceEq;
	}

	double closingBalanceEq;

	@JsonProperty("dbAmount")
	public double getDbAmount() {
		return this.dbAmount;
	}

	public void setDbAmount(double dbAmount) {
		this.dbAmount = dbAmount;
	}

	double dbAmount;

	@JsonProperty("dbAmountEq")
	public double getDbAmountEq() {
		return this.dbAmountEq;
	}

	public void setDbAmountEq(double dbAmountEq) {
		this.dbAmountEq = dbAmountEq;
	}

	double dbAmountEq;

	@JsonProperty("crAmount")
	public double getCrAmount() {
		return this.crAmount;
	}

	public void setCrAmount(double crAmount) {
		this.crAmount = crAmount;
	}

	double crAmount;

	@JsonProperty("crAmountEq")
	public double getCrAmountEq() {
		return this.crAmountEq;
	}

	public void setCrAmountEq(double crAmountEq) {
		this.crAmountEq = crAmountEq;
	}

	double crAmountEq;

	@Override
	public String toString() {
		return "Statistics [number=" + number + ", openingBalance=" + openingBalance + ", openingBalanceEq="
				+ openingBalanceEq + ", closingBalance=" + closingBalance + ", closingBalanceEq=" + closingBalanceEq
				+ ", dbAmount=" + dbAmount + ", dbAmountEq=" + dbAmountEq + ", crAmount=" + crAmount + ", crAmountEq="
				+ crAmountEq + "]";
	}
	
	
}
