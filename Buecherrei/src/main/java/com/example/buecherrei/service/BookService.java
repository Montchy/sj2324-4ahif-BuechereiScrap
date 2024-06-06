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

    public Object findBooksWithTitelLike(String titelLike) {
        return bookRepository.findAllByTitleLike(titelLike);
    }

    public Book addBook(String title, String author, BookGenre bookGenre, String language, String mainCharacter, String publisher, String blurb){
        if(bookRepository.existsByTitle(title)) throw BookAlreadyExistsException.forBookTitle(title);
        Book book = Book.builder().title(title).author(author).genre(bookGenre).language(language).mainCharacter(mainCharacter).publisher(publisher).blurb(blurb).build();
        bookRepository.save(book);
        return book;
    }

    public Book createBook(String title, String author, BookGenre genre, String language, String mainCharacter, String publisher, String blurb){
        //log.debug("Check if title {} already exists", title);

        if(bookRepository.existsByTitle(new String(title))){
            throw BookAlreadyExistsException.forBookTitle(title);
        }

       // log.debug("Create book {}", title);
        Book book = Book.builder()
                .title(new String(title))
                .author(author)
                .genre(genre)
                .language(language)
                .mainCharacter(mainCharacter)
                .publisher(publisher)
                .blurb(blurb)
                .build();
        bookRepository.save(book);
        //log.info("Successfully created book {} (id={}, key={})!", title, book.getId(), book.getKey());

       // log.debug("Create activation token for book {} (id={})", title, book.getId());

       // log.debug("Send confirmation notification for book {} (id={})", title, book.getId());

        return book;
    }


    public void getBookForKey(String key) {

    }
}

