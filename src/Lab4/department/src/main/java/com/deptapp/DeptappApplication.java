package com.deptapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DeptappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DeptappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("SERVER STARTED ON PORT 8083");
	}
}
