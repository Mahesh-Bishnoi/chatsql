package com.maheshbishnoi.chatsql;

public class EmptyResultException extends Exception {
    EmptyResultException(String response) {
        super(response);
    }
}
