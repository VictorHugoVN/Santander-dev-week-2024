package me.dio.sdw.adapters.in;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.sdw.application.ListChampionsUseCases;
import me.dio.sdw.domain.model.Champions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(name="Campeões", description="Endpoints do domínio de Campeões do Lol")
@RestController
@RequestMapping(value = "/champions")
public record ListChampionsRestController(ListChampionsUseCases useCases) {

    @GetMapping
    public List<Champions> findAll(){
        return useCases.findAll();
    }

}
