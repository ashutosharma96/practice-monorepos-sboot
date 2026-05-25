package com.example.AiDemo;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AiController {


    private EmbeddingModel embeddingModel;
    private final ChatClient chatClient;


    public AiController(ChatClient.Builder builder, EmbeddingModel embeddingModel){
        this.chatClient = builder.build();
        this.embeddingModel = embeddingModel;
    }

    @GetMapping("/api/{message}")
    public ResponseEntity<String> getAnus(@PathVariable String message){
        ChatResponse chatResponse= chatClient.prompt(message)
                .call().chatResponse();

        System.out.println(chatResponse.getMetadata().getModel());

        String response = chatResponse.getResult().getOutput().getText();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/recommend")
    public ResponseEntity<String> recommend(@RequestParam String genre, String lang, String year){

        String template = """
                Suggest me a great {lang} movie released on/around the year {year} whose genre is {genre}.
                Prioritize your selection of movie based on rotten tomato ratings, then imdb ratings.
                Give a short plot description also with cast details in a very structured manner. 
                Make the whole response very short and structured without additional comments or explainations
                """;

        PromptTemplate promptTemplate = new PromptTemplate(template);
        Prompt prompt = promptTemplate.create(Map.of("lang", lang, "year", year, "genre", genre));

        String response = chatClient.prompt(prompt).call().content();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/embedding")
        public float[] embedding(@RequestParam String text){

        return embeddingModel.embed(text);
    }
}

