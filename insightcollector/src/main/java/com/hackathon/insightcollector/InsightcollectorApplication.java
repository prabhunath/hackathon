package com.hackathon.insightcollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@ServletComponentScan
@SpringBootApplication
public class InsightcollectorApplication  implements WebMvcConfigurer {


	public void addViewController(ViewControllerRegistry registry)
	{
		System.out.println("************************&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		registry.addViewController("/index").setViewName("index");
	}

	public static void main(String[] args) {
		SpringApplication.run(InsightcollectorApplication.class, args);
	}

}
