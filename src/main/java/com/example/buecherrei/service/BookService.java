package com.example.buecherrei.service;

import com.example.buecherrei.domain.Book;
import com.example.buecherrei.domain.BookGenre;
import com.example.buecherrei.persistence.BookRepository;

import com.example.buecherrei.service.exceptions.BookAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getBooks() {
       return bookRepository.findAll();
    }

    public Book addBook(String title, String author, BookGenre bookGenre, String language, String mainCharacter, String publisher, String blurb){
        if(bookRepository.existsByTitle(title)) throw BookAlreadyExistsException.forBookTitle(title);
        Book book = Book.builder().title(title).author(author).genre(bookGenre).language(language).mainCharacter(mainCharacter).publisher(publisher).blurb(blurb).build();
        bookRepository.save(book);
        return book;
    }

}

