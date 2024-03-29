package me.dio.sdw.adapters.in;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.sdw.application.AskChampionUseCases;
import me.dio.sdw.application.ListChampionsUseCases;
import me.dio.sdw.domain.model.Champions;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Campeões", description="Endpoints do domínio de Campeões do Lol")
@RestController
@RequestMapping(value = "/champions")
public record AskChampionsRestController(AskChampionUseCases useCases) {

    @PostMapping("/{championId}/ask")
    public AskChampionResponse askChampion(@PathVariable Long championId, @RequestBody AskChampionRequest request){
        String answer = useCases.askChampion(championId, request.question());
        return new AskChampionResponse(answer);
    }

    public record AskChampionRequest(String question){}
    public record AskChampionResponse(String answer){}

}
