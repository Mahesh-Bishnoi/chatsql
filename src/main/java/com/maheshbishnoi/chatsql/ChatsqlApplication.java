package com.maheshbishnoi.chatsql;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.Charset;

@SpringBootApplication
public class ChatsqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatsqlApplication.class, args);
    }

    @Bean
    PromptTemplate systemPrompt(
            @Value("classpath:system-prompt.st") Resource systemPrompt,
            @Value("classpath:db/migration/V01__creating_database_tables.sql") Resource ddlSchema,
            @Value("${database.type}") String databaseType
    ) throws IOException {
        PromptTemplate template = new PromptTemplate(systemPrompt);
        template.add("ddl", ddlSchema.getContentAsString(Charset.defaultCharset()));
        template.add("databaseType", databaseType);
        return template;
    }

    @Bean
    ChatClient chatClient(OllamaChatModel chatModel, PromptTemplate systemPrompt) {
        return ChatClient
                .builder(chatModel)
                .defaultSystem(systemPrompt.render())
                .build();
    }
}
