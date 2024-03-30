package me.dio.sdw.domain.ports;

public interface GenerativeAiApi {
    String generateContent(String objective, String context);

    String generateContext(String objective, String context);
}
