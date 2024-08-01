package com.mario.dev.moubus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.mario.dev.moubus.security.RsaKeyProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class MoubusApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoubusApplication.class, args);
	}

}
