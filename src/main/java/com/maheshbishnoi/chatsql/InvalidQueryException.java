package com.maheshbishnoi.chatsql;

public class InvalidQueryException extends Exception {
    public InvalidQueryException(String response) {
        super(response);
    }
}
