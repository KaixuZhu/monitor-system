package com.zr.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;



@SpringBootApplication
@EnableDubbo
@MapperScan("com.zr.auth.mapper")
public class AuthMainApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AuthMainApplication.class, args);
	}

}
