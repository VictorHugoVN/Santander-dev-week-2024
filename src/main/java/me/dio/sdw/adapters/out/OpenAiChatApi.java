package me.dio.sdw.adapters.out;

import me.dio.sdw.domain.ports.GenerativeAiApi;
import org.aspectj.bridge.Message;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "OpenAiChatApi", url = "${openai.base-url}")
public interface OpenAiChatApi extends GenerativeAiApi {

    @PostMapping("/v1/chat/completions")
    OpenAiChatCompletionRes chatCompletion(OpenAiChatCompletionReq req);

    @Override
    default String generateContext(String objective, String context){
        String model = "gpt-3.5-turbo";
        List<Message> messages = List.of(
                new Message("system", objective),
                new Message("user", context)
        );
        OpenAiChatCompletionReq req = new OpenAiChatCompletionReq(model, messages);
        OpenAiChatCompletionRes resp = chatCompletion(req);
        return resp.choices().getFirst().message().content;
    }

    public record OpenAiChatCompletionReq(String model, List<Message> messages){}
    public record Message(String role, String content){}

    public record OpenAiChatCompletionRes(List<Choice> choices){}
    public record Choice(Message message){}

}
