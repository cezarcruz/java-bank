package br.com.cezarcruz.javabank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaBankApplication {

	public static void main(final String...args) {
		
		var x = "fuu";
		
		SpringApplication.run(JavaBankApplication.class, args);
	}

}
