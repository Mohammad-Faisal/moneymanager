package com.faisal.moneymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MoneymanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneymanagerApplication.class, args);
	}

}
