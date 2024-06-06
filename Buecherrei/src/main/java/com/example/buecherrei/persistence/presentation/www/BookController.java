package com.example.buecherrei.persistence.presentation.www;


import com.example.buecherrei.domain.Book;
import com.example.buecherrei.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.internal.CreateKeySecondPass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/create")
    public String getCreateBookForm(Model model){
    model.addAttribute("form", CreateBookForm.init());
            return "books/create";
    }

    @GetMapping("/create")
    public String handleCreateBookFormSubmission(Model model, @Valid @ModelAttribute(name="form") CreateBookForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/books";
        }

        bookService.createBook(form.titel(), form.author(), form.genre(), form.language(), form.mainCharacter(), form.publisher(), form.blurb());
        return "redirect:/books";
    }

    @GetMapping("/edit/{key}")
    public String getEditBookForm(Model model, @PathVariable String key){
        bookService.getBookForKey(key);
        model.addAttribute("form", EditBookForm.init());
        return "books/create";
    }

    @GetMapping("/edit/{key}")
    public String handleEditBookFormSubmission(Model model, @Valid @ModelAttribute(name="form") CreateBookForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/books";
        }

        bookService.addBook(form.titel(), form.author(), form.genre(), form.language(), form.mainCharacter(), form.publisher(), form.blurb());
        return "redirect:/books";
    }


}
