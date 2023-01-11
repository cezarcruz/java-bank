package br.com.cezarcruz.javabank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JavaBankApplication {

	public static void main(final String...args) {
		SpringApplication.run(JavaBankApplication.class, args);
	}

}
