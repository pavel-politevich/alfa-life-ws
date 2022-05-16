package by.lifetech.alfalife.model;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Page {
	
	Logger logger = LoggerFactory.getLogger(Page.class);

	@JsonProperty("number")
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	String number;

	@JsonProperty("operType")
	public String getOperType() {
		return this.operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	String operType;

	@JsonProperty("operCode")
	public int getOperCode() {
		return this.operCode;
	}

	public void setOperCode(int operCode) {
		this.operCode = operCode;
	}

	int operCode;

	@JsonProperty("operCodeName")
	public String getOperCodeName() {
		return this.operCodeName;
	}

	public void setOperCodeName(String operCodeName) {
		this.operCodeName = operCodeName;
	}

	String operCodeName;

	@JsonProperty("operDate")
	public String getOperDate() {
		return this.operDate;
	}

	public void setOperDate(String operDate) {
		this.operDate = operDate;
	}

	String operDate;

	@JsonProperty("acceptDate")
	public Date getAcceptDate() {
		return this.acceptDate;
	}

	public void setAcceptDate(Date acceptDate) {
		this.acceptDate = acceptDate;
	}

	Date acceptDate;

	@JsonProperty("docId")
	public String getDocId() {
		return this.docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	String docId;

	@JsonProperty("docNum")
	public String getDocNum() {
		return this.docNum;
	}

	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}

	String docNum;

	@JsonProperty("docType")
	public String getDocType() {
		return this.docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	String docType;

	@JsonProperty("amount")
	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	double amount;

	@JsonProperty("amountEq")
	public double getAmountEq() {
		return this.amountEq;
	}

	public void setAmountEq(double amountEq) {
		this.amountEq = amountEq;
	}

	double amountEq;

	@JsonProperty("currCode")
	public int getCurrCode() {
		return this.currCode;
	}

	public void setCurrCode(int currCode) {
		this.currCode = currCode;
	}

	int currCode;

	@JsonProperty("currIso")
	public String getCurrIso() {
		return this.currIso;
	}

	public void setCurrIso(String currIso) {
		this.currIso = currIso;
	}

	String currIso;

	@JsonProperty("purpose")
	public String getPurpose() {
		if (this.purpose != null && this.purpose.contains(";")) {
			this.purpose = this.purpose.replaceAll(";", " ");
			logger.warn("В описании платежа #" + getDocNum() + " убран символ ';' !");
		}
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	String purpose;

	@JsonProperty("corrName")
	public String getCorrName() {
		return this.corrName;
	}

	public void setCorrName(String corrName) {
		this.corrName = corrName;
	}

	String corrName;

	@JsonProperty("corrUnp")
	public String getCorrUnp() {
		return this.corrUnp;
	}

	public void setCorrUnp(String corrUnp) {
		this.corrUnp = corrUnp;
	}

	String corrUnp;

	@JsonProperty("corrNumber")
	public String getCorrNumber() {
		return this.corrNumber;
	}

	public void setCorrNumber(String corrNumber) {
		this.corrNumber = corrNumber;
	}

	String corrNumber;

	@JsonProperty("corrBic")
	public String getCorrBic() {
		return this.corrBic;
	}

	public void setCorrBic(String corrBic) {
		this.corrBic = corrBic;
	}

	String corrBic;

	@JsonProperty("corrBank")
	public String getCorrBank() {
		return this.corrBank;
	}

	public void setCorrBank(String corrBank) {
		this.corrBank = corrBank;
	}

	String corrBank;

	@JsonProperty("budgetCode")
	public String getBudgetCode() {
		return this.budgetCode;
	}

	public void setBudgetCode(String budgetCode) {
		this.budgetCode = budgetCode;
	}

	String budgetCode;

	@JsonProperty("printId")
	public String getPrintId() {
		return this.printId;
	}

	public void setPrintId(String printId) {
		this.printId = printId;
	}

	String printId;

	@JsonProperty("unpThird")
	public Object getUnpThird() {
		return this.unpThird;
	}

	public void setUnpThird(Object unpThird) {
		this.unpThird = unpThird;
	}

	Object unpThird;

	@JsonProperty("realRate")
	public Object getRealRate() {
		return this.realRate;
	}

	public void setRealRate(Object realRate) {
		this.realRate = realRate;
	}

	Object realRate;

	@JsonProperty("sumPaymentInstruction")
	public Object getSumPaymentInstruction() {
		return this.sumPaymentInstruction;
	}

	public void setSumPaymentInstruction(Object sumPaymentInstruction) {
		this.sumPaymentInstruction = sumPaymentInstruction;
	}

	Object sumPaymentInstruction;

	@JsonProperty("currPaymentInstruction")
	public Object getCurrPaymentInstruction() {
		return this.currPaymentInstruction;
	}

	public void setCurrPaymentInstruction(Object currPaymentInstruction) {
		this.currPaymentInstruction = currPaymentInstruction;
	}

	Object currPaymentInstruction;

	@Override
	public String toString() {
		return "Page [number=" + number + ", operType=" + operType + ", operCode=" + operCode + ", operCodeName="
				+ operCodeName + ", operDate=" + operDate + ", acceptDate=" + acceptDate + ", docId=" + docId
				+ ", docNum=" + docNum + ", docType=" + docType + ", amount=" + amount + ", amountEq=" + amountEq
				+ ", currCode=" + currCode + ", currIso=" + currIso + ", purpose=" + purpose + ", corrName=" + corrName
				+ ", corrUnp=" + corrUnp + ", corrNumber=" + corrNumber + ", corrBic=" + corrBic + ", corrBank="
				+ corrBank + ", budgetCode=" + budgetCode + ", printId=" + printId + ", unpThird=" + unpThird
				+ ", realRate=" + realRate + ", sumPaymentInstruction=" + sumPaymentInstruction
				+ ", currPaymentInstruction=" + currPaymentInstruction + "]";
	}
	
	public String toFileFormat() {
		return docNum + ";" + corrBic + ";" + corrNumber + ";" + corrUnp + ";" + amountEq
				+ ";" + operDate + ";" + getPurpose();
	}
	
	
}
