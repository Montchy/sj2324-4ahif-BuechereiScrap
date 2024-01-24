package com.example.buecherrei.service;

import com.example.buecherrei.domain.Book;
import com.example.buecherrei.persistence.BookRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getBooks() {
       return bookRepository.findAll();
    }
}

