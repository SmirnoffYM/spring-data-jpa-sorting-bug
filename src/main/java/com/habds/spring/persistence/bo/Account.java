package com.habds.spring.persistence.bo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal amount;
    private String currency;

    @ManyToOne
    private User user;

    protected Account() {
    }

    public Account(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
