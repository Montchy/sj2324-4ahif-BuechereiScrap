package com.example.buecherrei.persistence.presentation.api;


import com.example.buecherrei.TestFixtures;
import com.example.buecherrei.domain.Book;
import com.example.buecherrei.domain.BookGenre;
import com.example.buecherrei.persistence.presentation.www.BookController;
import com.example.buecherrei.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)
class BookControllerTest {

    private @Autowired MockMvc mockMvc;
    private @MockBean BookService bookService;

    @Test
    void ensureGetBooksReturnsHttpStatusOkAndListView() throws Exception {
        Book ab = TestFixtures.book("Herr der Ringe", "Jk", BookGenre.Fantasy, "Deutsch", "Harry Potter", "Disney", "gg");
        Book bc = TestFixtures.book("Pipi Langstrumpf", "Astird", BookGenre.Novel, "Deutsch", "Pipi", "Disney", "gg");
        List<Book> books = List.of(ab, bc);
        when(bookService.getBooks()).thenReturn(books);

        mockMvc.perform((get("/books")))
                .andExpect(status().isOk())
                .andExpect(view().name("books/list"))
                .andExpect(model().attribute("books", books))
                .andDo(print());
    }

}

