package com.szc.springboot.demo.acs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.szc.springboot.demo.acs.dao")
public class AcsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcsApplication.class, args);
	}

}

