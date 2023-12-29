package com.application.webapi.model;
import java.io.Serializable;
import java.math.BigDecimal;
import org.springframework.data.elasticsearch.annotations.Document;
import java.util.Objects;

@Document(indexName = "deposits")
public class Dokumen  implements Serializable{
    private int id; 
    private String userId; 
    private String source; 
    private BigDecimal amount;
    private String status;
    private int createdAt; 
    private int updatedAt;

    public Dokumen() {
    }

    public Dokumen(int id, String userId, String source, BigDecimal amount, String status, int createdAt, int updatedAt) {
        this.id = id;
        this.userId = userId;
        this.source = source;
        this.amount = amount;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Dokumen id(int id) {
        setId(id);
        return this;
    }

    public Dokumen userId(String userId) {
        setUserId(userId);
        return this;
    }

    public Dokumen source(String source) {
        setSource(source);
        return this;
    }

    public Dokumen amount(BigDecimal amount) {
        setAmount(amount);
        return this;
    }

    public Dokumen status(String status) {
        setStatus(status);
        return this;
    }

    public Dokumen createdAt(int createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    public Dokumen updatedAt(int updatedAt) {
        setUpdatedAt(updatedAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Dokumen)) {
            return false;
        }
        Dokumen dokumen = (Dokumen) o;
        return id == dokumen.id && Objects.equals(userId, dokumen.userId) && Objects.equals(source, dokumen.source) && Objects.equals(amount, dokumen.amount) && Objects.equals(status, dokumen.status) && createdAt == dokumen.createdAt && updatedAt == dokumen.updatedAt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, source, amount, status, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", source='" + getSource() + "'" +
            ", amount='" + getAmount() + "'" +
            ", status='" + getStatus() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }

    

}