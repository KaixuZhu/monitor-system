package com.zr.monitor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;



@SpringBootApplication
@EnableDubbo
@MapperScan("com.zr.monitor.mapper")
public class MonitorMainApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(MonitorMainApplication.class, args);
	}

}
