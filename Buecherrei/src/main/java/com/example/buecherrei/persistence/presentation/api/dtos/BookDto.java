package com.example.buecherrei.persistence.presentation.api.dtos;

import com.example.buecherrei.domain.Book;


public record BookDto(String key,String titel, String author) {

    public BookDto(Book b){
        this(b.getKey(), b.getTitle(), b.getAuthor());
    }


}
