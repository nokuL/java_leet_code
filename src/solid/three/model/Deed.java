package solid.three.model;

import solid.three.model.DeedStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Deed {

    private Long id;
    private String deedNumber;
    private String propertyDescription;
    private String ownerNationalId;
    private String previousOwnerNationalId;
    private DeedStatus status;
    private BigDecimal propertyValue;
    private LocalDate registeredDate;
    private LocalDate transferDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Deed() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.registeredDate = LocalDate.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDeedNumber() { return deedNumber; }
    public void setDeedNumber(String deedNumber) { this.deedNumber = deedNumber; }

    public String getPropertyDescription() { return propertyDescription; }
    public void setPropertyDescription(String propertyDescription) {
        this.propertyDescription = propertyDescription;
    }

    public String getOwnerNationalId() { return ownerNationalId; }
    public void setOwnerNationalId(String ownerNationalId) {
        this.ownerNationalId = ownerNationalId;
    }

    public String getPreviousOwnerNationalId() { return previousOwnerNationalId; }
    public void setPreviousOwnerNationalId(String previousOwnerNationalId) {
        this.previousOwnerNationalId = previousOwnerNationalId;
    }

    public DeedStatus getStatus() { return status; }
    public void setStatus(DeedStatus status) { this.status = status; }

    public BigDecimal getPropertyValue() { return propertyValue; }
    public void setPropertyValue(BigDecimal propertyValue) {
        this.propertyValue = propertyValue;
    }

    public LocalDate getRegisteredDate() { return registeredDate; }
    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    public LocalDate getTransferDate() { return transferDate; }
    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "Deed{" +
                "id=" + id +
                ", deedNumber='" + deedNumber + '\'' +
                ", ownerNationalId='" + ownerNationalId + '\'' +
                ", status=" + status +
                ", propertyValue=" + propertyValue +
                '}';
    }
}