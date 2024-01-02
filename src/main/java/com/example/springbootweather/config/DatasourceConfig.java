package com.example.springbootweather.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@EnableScheduling
@Configuration
public class DatasourceConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public DatasourceConfig(DataSource dataSource) {
    }
}








