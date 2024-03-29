package me.dio.sdw.application;

import me.dio.sdw.domain.exception.ChampionNotFoundException;
import me.dio.sdw.domain.model.Champions;
import me.dio.sdw.domain.ports.ChampionsRepository;

import java.util.List;

public record AskChampionUseCases(ChampionsRepository repository) {

    public String askChampion(Long championId, String question){

        Champions champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generatedContentByQuestion(question);
        //TODO: Evoluir a lógica de negócio para considerar a integração com IAs generativas.


        return championContext;
    }

}
