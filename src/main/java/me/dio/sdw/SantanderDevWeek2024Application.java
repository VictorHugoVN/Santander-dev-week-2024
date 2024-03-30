package me.dio.sdw;

import me.dio.sdw.application.AskChampionUseCases;
import me.dio.sdw.application.ListChampionsUseCases;
import me.dio.sdw.domain.ports.ChampionsRepository;
import me.dio.sdw.domain.ports.GenerativeAiApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class SantanderDevWeek2024Application {

	public static void main(String[] args) {
		SpringApplication.run(SantanderDevWeek2024Application.class, args);
	}

	@Bean
	public ListChampionsUseCases provideListChampionsUseCase(ChampionsRepository repository){
		return new ListChampionsUseCases(repository);
	}

	@Bean
	public AskChampionUseCases provideAskChampionUseCase(ChampionsRepository repository, GenerativeAiApi genAiApi){
		return new AskChampionUseCases(repository, genAiApi);
	}

}
