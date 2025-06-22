package com.maheshbishnoi.chatsql;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class SQLGenerator {

    private final ChatClient chatClient;

    SQLGenerator(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    String generate(String question) throws InvalidQueryException {
        String response = chatClient
                .prompt(question)
                .call()
                .content();

        if (response == null || !response.startsWith("SELECT")) {
            throw new InvalidQueryException(response);
        }
        return response;
    }
}