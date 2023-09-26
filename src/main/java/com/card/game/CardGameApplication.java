package com.card.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:properties/card-game-dev.properties")
@EnableAutoConfiguration(exclude={ErrorMvcAutoConfiguration.class})
public class CardGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardGameApplication.class, args);
	}

}
