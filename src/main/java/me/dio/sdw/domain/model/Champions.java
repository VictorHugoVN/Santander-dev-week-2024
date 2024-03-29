package me.dio.sdw.domain.model;

public record Champions(
        Long id,
        String name,
        String role,
        String lore,
        String imageUrl
) {

    public String generatedContentByQuestion(String question){
        return """
            Pergunta: %s
            Nome do campeão: %s
            Função: %s
            Lore (História): %s        
        """.formatted(question, this.name, this.role, this.lore);
    }



}
