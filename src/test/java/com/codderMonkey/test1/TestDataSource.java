/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codderMonkey.test1;

import com.codderMonkey.config.SpringRootConfig;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author gajen
 */
public class TestDataSource {
    public static void main(String[] args) {
        // TODO code application logic here
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = ctx.getBean(DataSource.class);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql = "INSERT INTO user( `name`, `phone`, `email`, `address`, `loginName`, `password`) VALUES(?, ?, ?, ?, ?, ?)";
        Object[] param = new Object[] {"Gaz", "9812650", "gaz@gmail.com", "mysuru", "g", "gaz123"};
        jt.update(sql, param);
        System.out.println("----------------------------Insertion Successful -------------------------");
    }
    
}
