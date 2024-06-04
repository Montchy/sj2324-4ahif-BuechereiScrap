package com.example.buecherrei.persistence.presentation.www;


import com.example.buecherrei.domain.Book;
import com.example.buecherrei.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public String getBooks(Model model){
    List<Book> books = bookService.getBooks();
    model.addAttribute("books", books);
    return "books/list";
    }


}
