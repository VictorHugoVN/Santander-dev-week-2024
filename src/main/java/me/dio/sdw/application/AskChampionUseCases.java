package me.dio.sdw.application;

import me.dio.sdw.domain.exception.ChampionNotFoundException;
import me.dio.sdw.domain.model.Champions;
import me.dio.sdw.domain.ports.ChampionsRepository;
import me.dio.sdw.domain.ports.GenerativeAiApi;

import java.util.List;

public record AskChampionUseCases(ChampionsRepository repository, GenerativeAiApi genAiApi) {

    public String askChampion(Long championId, String question){

        Champions champion = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = champion.generatedContentByQuestion(question);
        String objective = """
                Atue como um assistente com a habilidade de se comportar como os campeões do League of Legends(LOL).
                Responda perguntas incorporando a personalidade e estilo de um determinado Campeão.
                Segue a pergunta, nome do Campeão, e sua respectiva lore(história):
                
                """;

        return genAiApi.generateContent(objective, championContext);
    }

}
