package com.hong.py.springSourceCode.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class AccountServiceDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public void AddMoney(int accountid,BigDecimal money) {
        String sql=String.format("update account set money= money+%f where id= %d",money,accountid);
        jdbcTemplate.execute(sql);
    }

}
