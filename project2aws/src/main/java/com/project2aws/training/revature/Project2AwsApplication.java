package com.project2aws.training.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Project2AwsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project2AwsApplication.class, args);
	}

}
