package com.example.buecherrei.persistence.presentation.api;

import com.example.buecherrei.domain.Book;
import com.example.buecherrei.domain.BookGenre;
import com.example.buecherrei.persistence.presentation.api.commands.CreateBookCommand;
import com.example.buecherrei.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookRestController {

    protected static final String BASE_URL = "/api/books";
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(@RequestParam Optional<String> titelLike) {
        List<Book> books = titelLike.map(bookService::findBooksWithTitelLike)
                                         .orElseGet(bookService::getBooks);

        return bookService.getBooks().isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(bookService.getBooks());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody @Valid CreateBookCommand cmd){
        Book book = bookService.addBook(cmd.title(),cmd.author(),cmd.genre(), cmd.language(), cmd.mainCharacter(),cmd.publisher(),cmd.blurb());
        if(book != null){
            URI location = URI.create("%s/%d".formatted("/api/books",book.getId()));
            return ResponseEntity.created(location).body(book);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }


}
