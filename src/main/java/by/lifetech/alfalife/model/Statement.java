package by.lifetech.alfalife.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Statement{
    public String number;
    public String operType;
    public int operCode;
    public String operCodeName;
    public String operDate;
    public Date acceptDate;
    public String docId;
    public String docNum;
    public String docType;
    public int amount;
    public int amountEq;
    public int currCode;
    public String currIso;
    public String purpose;
    public String corrName;
    public String corrUnp;
    public String corrNumber;
    public String corrBic;
    public String corrBank;
    public String budgetCode;
    public String printId;
    public String unpThird;
    public String realRate;
    public String sumPaymentInstruction;
    public String currPaymentInstruction;
}
