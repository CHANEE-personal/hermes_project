package com.chan;

import com.chan.configuration.swaggerConfiguration;
import com.google.common.base.Predicates;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.consumes(getConsumeContentTypes())
				.produces(getProduceContentTypes())
				.apiInfo(getApiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.chan.controller.api"))
				.paths(PathSelectors.ant("/api/**"))
				.paths(Predicates.not(PathSelectors.regex("/error.*")))
				.build()
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, getArrayList());
	}

	private Set<String> getConsumeContentTypes() {
		Set<String> consumes = new HashSet<>();
		consumes.add("application/json;charset=UTF-8");
		consumes.add("application/x-www-form-urlencoded");
		return consumes;
	}

	private Set<String> getProduceContentTypes() {
		Set<String> produces = new HashSet<>();
		produces.add("application/json;charset=UTF-8");
		return produces;
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("[CHAN] API")
				.description("[CHAN] API")
				.version("1.0")
				.build();
	}

	private ArrayList<ResponseMessage> getArrayList() {
		ArrayList<ResponseMessage> lists = new ArrayList<ResponseMessage>();

		lists.add(new ResponseMessageBuilder().code(500).message("서버에러").responseModel(new ModelRef("Error")).build());
		lists.add(new ResponseMessageBuilder().code(403).message("권한없음").responseModel(new ModelRef("Forbbiden")).build());

		return lists;
	}

}
