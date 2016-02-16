package com.habds.spring.persistence.bo;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Embeddable
public class Finances {

    @OneToOne(cascade = CascadeType.PERSIST)
    private Account selectedAccount;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

    public Account getSelectedAccount() {
        return selectedAccount;
    }

    public void setSelectedAccount(Account selectedAccount, User user) {
        this.selectedAccount = selectedAccount;
        selectedAccount.setUser(user);
    }
}
