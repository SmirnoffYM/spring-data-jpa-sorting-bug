package com.habds.spring;

import com.habds.spring.persistence.bo.Account;
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
        user.selectAccount(new Account(BigDecimal.TEN, "UAH"));

        User otherUser = new User();
        otherUser.selectAccount(new Account(null, null));

        User oneMoreUser = new User();

        dao.save(Arrays.asList(user, otherUser, oneMoreUser));

        Assert.assertEquals(3, dao.count());
        Assert.assertEquals(3, dao.findAll().size());
        Assert.assertEquals(3,
            dao.findAll(new Sort(Sort.Direction.DESC, "finances.selectedAccount.amount")).size());
    }
}
