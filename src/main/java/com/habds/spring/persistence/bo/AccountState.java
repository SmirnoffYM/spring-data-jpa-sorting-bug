package com.habds.spring.persistence.bo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class AccountState {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Account account;

    private BigDecimal amount;
    private String currency;

    protected AccountState() {
    }

    public AccountState(BigDecimal amount, String currency) {
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
}
