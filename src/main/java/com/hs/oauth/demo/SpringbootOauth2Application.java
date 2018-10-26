package com.hs.oauth.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
public class SpringbootOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootOauth2Application.class, args);
	}

}
