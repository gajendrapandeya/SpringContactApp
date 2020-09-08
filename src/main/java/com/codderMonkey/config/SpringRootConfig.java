/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codderMonkey.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.codderMonkey.dao")

public class SpringRootConfig {
    
    //TODO: Services, DAOs, datasource, email sender or somother business layer
    @Bean
    public BasicDataSource getDataSource(){
        
    BasicDataSource ds = new BasicDataSource();
    ds.setDriverClassName("com.mysql.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost:3306/capp_db");
    ds.setUsername("root");
    ds.setPassword("root");
    ds.setMaxTotal(2);
    ds.setInitialSize(1);
    ds.setTestOnBorrow(true);
    ds.setValidationQuery("SELECT 1");
    ds.setDefaultAutoCommit(true);
    return ds;
     
    }
    
}
