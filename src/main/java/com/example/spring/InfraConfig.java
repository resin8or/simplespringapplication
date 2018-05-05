package com.example.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by tobinj on 04/05/2018.
 */
@Configuration
public class InfraConfig {

    @Bean public DataSource ds(){

        return new DriverManagerDataSource();

    }
}
