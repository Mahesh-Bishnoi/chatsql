package com.maheshbishnoi.chatsql;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SQLExecutor {

    private final EntityManager entityManager;

    SQLExecutor(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    List<?> execute(String query) throws EmptyResultException {
        List<?> result = entityManager
                .createNativeQuery(query)
                .getResultList();
        if (result.isEmpty()) {
            throw new EmptyResultException("No results found for the provided query.");
        }
        return result;
    }
}