package com.example.springbootweather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages={"config", "places"})
public class SpringBootWeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWeatherApplication.class, args);

	}

}




