package com.zr.record;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;



@SpringBootApplication
@EnableDubbo
public class RecordMainApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RecordMainApplication.class, args);
	}

}
