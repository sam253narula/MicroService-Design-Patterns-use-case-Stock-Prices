package com.finance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.finance.service.BSEService;

@SpringBootApplication
public class BseServiceApplication /* implements CommandLineRunner */ {

	/*
	 * @Autowired BSEService bseService;
	 */

	public static void main(String[] args) {
		SpringApplication.run(BseServiceApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * System.out.println(bseService.getStockPrice("Tata Chem"));
	 * 
	 * }
	 */

}
