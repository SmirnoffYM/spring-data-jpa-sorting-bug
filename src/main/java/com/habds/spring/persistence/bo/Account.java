package com.habds.spring.persistence.bo;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private AccountState state;

    @ManyToOne
    private User user;

    protected Account() {
    }

    public Account(AccountState state) {
        setState(state);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        if (state != null) {
            this.state = state;
            state.setAccount(this);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
