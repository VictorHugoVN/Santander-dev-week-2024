package me.dio.sdw.application;

import me.dio.sdw.domain.model.Champions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ListChampionsUseCasesIntegrationTest {

    @Autowired
    private ListChampionsUseCases listChampionsUseCases;


    @Test
    public void testListChampions(){
        List<Champions> champions = listChampionsUseCases.findAll();
        Assertions.assertEquals(12, champions.size());
    }

}
