package com.example.buecherrei.persistence.presentation.api;

import com.example.buecherrei.domain.Book;
import com.example.buecherrei.service.BookService;

import java.util.List;

@RequiredArgConstructor
@RestController
@RequestMapping("/api/books")
public class BookRestController {
    private final BookService bookService;

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }
}
