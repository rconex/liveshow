package com.nero.liveshow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.util.List;

@SpringBootApplication
public class LiveshowApplication {

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConventers() {
		GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
		return new HttpMessageConverters(converter);
	}

	public static void main(String[] args) {
		SpringApplication.run(LiveshowApplication.class, args);
	}
}
