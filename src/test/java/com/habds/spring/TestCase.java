package com.habds.spring;

import com.habds.spring.persistence.bo.Account;
import com.habds.spring.persistence.bo.AccountState;
import com.habds.spring.persistence.bo.User;
import com.habds.spring.persistence.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Config.class)
public class TestCase {

    @Autowired
    private UserDao dao;

    @Test
    public void testSortingBug() {
        User user = new User();
        user.selectAccount(new Account(new AccountState(BigDecimal.TEN, "UAH")));

        User otherUser = new User();
        otherUser.selectAccount(new Account(new AccountState(null, null)));

        User oneMoreUser = new User();
        oneMoreUser.selectAccount(new Account(null));

        User lastUser = new User();

        dao.save(Arrays.asList(user, otherUser, oneMoreUser, lastUser));

        Assert.assertEquals(4, dao.count());
        Assert.assertEquals(4, dao.findAll().size());
        Assert.assertEquals(4,
            dao.findAll(new Sort(Sort.Direction.DESC, "finances.selectedAccount.state.amount")).size());
    }
}
