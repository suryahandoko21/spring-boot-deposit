package com.application.webapi.model;
import java.io.Serializable;
import java.math.BigDecimal;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Objects;
@Document(collection = "deposits")
public class Deposit implements Serializable {
    private String userId; 
    private String source; 
    private BigDecimal amount;
    private String status;
    private int createdAt; 
    private int updatedAt; 

    public Deposit() {
    }

    public Deposit(String userId, String source, BigDecimal amount, String status, int createdAt, int updatedAt) {
        this.userId = userId;
        this.source = source;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public int getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(int updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Deposit userId(String userId) {
        setUserId(userId);
        return this;
    }

    public Deposit source(String source) {
        setSource(source);
        return this;
    }

    public Deposit amount(BigDecimal amount) {
        setAmount(amount);
        return this;
    }

    public Deposit status(String status) {
        setStatus(status);
        return this;
    }

    public Deposit createdAt(int createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public Deposit updatedAt(int updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Deposit)) {
            return false;
        }
        Deposit deposit = (Deposit) o;
        return Objects.equals(userId, deposit.userId) && Objects.equals(source, deposit.source) && Objects.equals(amount, deposit.amount) && Objects.equals(status, deposit.status) && createdAt == deposit.createdAt && updatedAt == deposit.updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, source, amount, status, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", source='" + getSource() + "'" +
            ", amount='" + getAmount() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
   

   
}
