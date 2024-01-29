package com.example.buecherrei.service.exceptions;

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String message) {
        super(message);
    }

    public static BookAlreadyExistsException forBookTitle(String msg){
        String message = "Book with title %s already exists".formatted(msg);
        return new BookAlreadyExistsException(message);
    }

}
