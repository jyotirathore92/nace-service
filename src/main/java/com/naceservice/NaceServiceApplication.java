package com.naceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class is the triggering point of the NACE Service Application Micro-service
 * which provides API's for adding NACE data and viewing all the NACE 
 * data present in the application.
 *
 * @author Jyoti
 */

@SpringBootApplication
public class NaceServiceApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(NaceServiceApplication.class, args);

	}

}
