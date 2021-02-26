package com.chan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@MapperScan(basePackages = "com.chan.mapper")
@ComponentScans({
		@ComponentScan(basePackages = "com.chan.controller"),
		@ComponentScan(basePackages = "com.chan.service")
})
@SpringBootApplication(scanBasePackages = "com")
@EnableSwagger2
public class HermesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HermesProjectApplication.class, args);
	}

}
