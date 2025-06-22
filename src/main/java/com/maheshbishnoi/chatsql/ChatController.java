package com.maheshbishnoi.chatsql;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ChatController {

    private final SQLGenerator sqlGenerator;
    private final SQLExecutor sqlExecutor;

    public ChatController(SQLGenerator sqlGenerator, SQLExecutor sqlExecutor) {
        this.sqlGenerator = sqlGenerator;
        this.sqlExecutor = sqlExecutor;
    }

    @GetMapping(value = "/ai/query")
    ResponseEntity<QueryResponse> query(@RequestParam( defaultValue = "") String question) throws InvalidQueryException, EmptyResultException {
        String sqlQuery = sqlGenerator.generate(question);
        List<?> result = sqlExecutor.execute(sqlQuery);
        return ResponseEntity.ok(new QueryResponse(result));
    }

    record QueryResponse(List<?> result) {
    }

}