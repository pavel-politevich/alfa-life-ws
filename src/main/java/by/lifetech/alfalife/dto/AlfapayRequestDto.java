package by.lifetech.alfalife.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Component
@Table(name="ALFAPAY_REQUESTS")
public class AlfapayRequestDto {

    @Id
	@GeneratedValue(generator="InvSeq")
	@SequenceGenerator(name="InvSeq",sequenceName="ALFAPAY_REQUEST_SEQ", allocationSize=1)
    private Long id;

    @Column(name="INSERT_DATE")
    private LocalDateTime insertDate;

    @Column(name="DOC_ID")
    private String docId;

    @Column(name="CORR_NUMBER")
    private String corrNum;

    @Column(name="CORR_UNP")
    private String corrUnp;

    @Column(name="AMOUNT")
    private double amount;

    @Column(name="OPER_DATE")
    private LocalDate operDate;

    public AlfapayRequestDto(Long id, LocalDateTime insertDate, String docId, String corrNum, String corrUnp,
            double amount, LocalDate operDate) {
        this.id = id;
        this.insertDate = insertDate;
        this.docId = docId;
        this.corrNum = corrNum;
        this.corrUnp = corrUnp;
        this.amount = amount;
        this.operDate = operDate;
    }

    public AlfapayRequestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getCorrNum() {
        return corrNum;
    }

    public void setCorrNum(String corrNum) {
        this.corrNum = corrNum;
    }

    public String getCorrUnp() {
        return corrUnp;
    }

    public void setCorrUnp(String corrUnp) {
        this.corrUnp = corrUnp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getOperDate() {
        return operDate;
    }

    public void setOperDate(LocalDate operDate) {
        this.operDate = operDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((docId == null) ? 0 : docId.hashCode());
        result = prime * result + ((corrNum == null) ? 0 : corrNum.hashCode());
        result = prime * result + ((corrUnp == null) ? 0 : corrUnp.hashCode());
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((operDate == null) ? 0 : operDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AlfapayRequestDto other = (AlfapayRequestDto) obj;
        if (docId == null) {
            if (other.docId != null)
                return false;
        } else if (!docId.equals(other.docId))
            return false;
        if (corrNum == null) {
            if (other.corrNum != null)
                return false;
        } else if (!corrNum.equals(other.corrNum))
            return false;
        if (corrUnp == null) {
            if (other.corrUnp != null)
                return false;
        } else if (!corrUnp.equals(other.corrUnp))
            return false;
        if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
            return false;
        if (operDate == null) {
            if (other.operDate != null)
                return false;
        } else if (!operDate.equals(other.operDate))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AlfapayRequestDto [id=" + id + ", insertDate=" + insertDate + ", docId=" + docId + ", corrNum="
                + corrNum + ", corrUnp=" + corrUnp + ", amount=" + amount + ", operDate=" + operDate + "]";
    }

    
    
}
