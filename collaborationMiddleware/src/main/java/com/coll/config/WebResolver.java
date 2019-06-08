package com.coll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.coll.*")
public class WebResolver {

	@Bean
	public InternalResourceViewResolver getViewResolver()
	{
	System.out.println("---View Resolver Bean Creation---");
	InternalResourceViewResolver iResolver= new InternalResourceViewResolver();
	iResolver.setPrefix("/WEB-INF/jsp");
	iResolver.setSuffix(".jsp");
	return iResolver;
	}
}
