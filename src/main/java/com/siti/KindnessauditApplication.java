package com.siti;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@MapperScan("com.siti.*.mapper")
@ServletComponentScan
public class KindnessauditApplication {

	public static void main(String[] args) {
		SpringApplication.run(KindnessauditApplication.class, args);
	}

}
