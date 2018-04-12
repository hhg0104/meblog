package com.hhg0104;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@SpringBootApplication
@EnableEncryptableProperties
public class MeBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeBlogApplication.class, args);
	}
}
