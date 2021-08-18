package br.com.list.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication /*(exclude = {DataSourceAutoConfiguration.class })*/
public class ListBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListBooksApplication.class, args);
	}

}
