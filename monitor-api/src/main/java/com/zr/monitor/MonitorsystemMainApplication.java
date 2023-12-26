package com.zr.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;

@SpringBootApplication
@EnableDubboConfig
public class MonitorsystemMainApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MonitorsystemMainApplication.class, args);
	}

}
