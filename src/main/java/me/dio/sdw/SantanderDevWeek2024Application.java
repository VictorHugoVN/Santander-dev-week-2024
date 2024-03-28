package me.dio.sdw;

import me.dio.sdw.application.ListChampionsUseCases;
import me.dio.sdw.domain.ports.ChampionsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SantanderDevWeek2024Application {

	public static void main(String[] args) {
		SpringApplication.run(SantanderDevWeek2024Application.class, args);
	}

	@Bean
	public ListChampionsUseCases provideListChampionsUseCase(ChampionsRepository repository){
		return new ListChampionsUseCases(repository);
	}

}
