package com.phoebus.teste.starwarsnetwork;

import com.phoebus.teste.starwarsnetwork.domain.Item;
import com.phoebus.teste.starwarsnetwork.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StarWarsNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarWarsNetworkApplication.class, args);
	}
}
