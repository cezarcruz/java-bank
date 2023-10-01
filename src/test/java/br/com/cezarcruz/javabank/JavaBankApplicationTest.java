package br.com.cezarcruz.javabank;

import br.com.cezarcruz.javabank.config.MongoDBContainerDevMode;
import org.springframework.boot.SpringApplication;

public class JavaBankApplicationTest {

    public static void main(final String...args) {
        SpringApplication.from(JavaBankApplication::main)
                .with(MongoDBContainerDevMode.class)
                .run(args);
    }

}
