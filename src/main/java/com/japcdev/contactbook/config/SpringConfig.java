package com.japcdev.contactbook.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.jdbc.core.JdbcTemplate;

@ComponentScan(basePackages = { "com.japcdev.contactbook.repository", "com.japcdev.contactbook.service" })
@Configuration
@PropertySource(value = { "config.properties" })
public class SpringConfig {
	@Value("${DB_DRIVER}")
	private String DB_DRIVER;
	
	@Value("${DB_URL}")
	private String DB_URL;
	
	@Value("${DB_USER}")
	private String DB_USER;

	@Value("${DB_PASS}")
	private String DB_PASS;

	
	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource data = new DriverManagerDataSource();

		data.setDriverClassName(DB_DRIVER);
		data.setUrl(DB_URL);
		data.setUsername(DB_USER);
		data.setPassword(DB_PASS); 

		return data;
	}

	@Bean
	public JdbcTemplate getTemplate(DataSource datasource) {
		return new JdbcTemplate(datasource);
	}
}
