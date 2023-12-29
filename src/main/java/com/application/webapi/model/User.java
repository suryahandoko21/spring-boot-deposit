package com.application.webapi.model;
import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Objects;
@Document(collection = "users")
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private BigDecimal balance;

    public User() {
    }

    public User(String id, String name, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User id(String id) {
        setId(id);
        return this;
    }

    public User name(String name) {
        setName(name);
        return this;
    }

    public User balance(BigDecimal balance) {
        setBalance(balance);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(balance, user.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, balance);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", balance='" + getBalance() + "'" +
            "}";
    }
}
