package com.chan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan(basePackages= {"com.chan.controller"})
@EnableSwagger2
public class HermesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HermesProjectApplication.class, args);
	}

}
