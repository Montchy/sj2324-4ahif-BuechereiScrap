package com.example.buecherrei.persistence.presentation.api;

import com.example.buecherrei.domain.Book;
import com.example.buecherrei.domain.BookGenre;
import com.example.buecherrei.persistence.presentation.api.commands.CreateBookCommand;
import com.example.buecherrei.service.BookService;
import com.example.buecherrei.service.exceptions.BookAlreadyExistsException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.any;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {
    private @Autowired MockMvc mockMvc;
    private @MockBean BookService bookService;
    private @Autowired ObjectMapper mapper;

    @Test
    void ensureGetBooksWithNoDataDeliversStatusOkAndEmptyArray() throws Exception{
        when(bookService.getBooks()).thenReturn(Collections.emptyList());
        var request = get(BookRestController.BASE_URL).accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request)
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    void ensureGetBooksWithDataDeliversStatusOkAndProperlyPopulatedArray() throws Exception {
        var book = Book.builder()
                .title("titel")
                .blurb("blurb")
                .genre(BookGenre.Comic)
                .author("author")
                .language("lang")
                .publisher("pub")
                .mainCharacter("Dieter Bohlen")
                .build();;
        when(bookService.getBooks()).thenReturn(List.of(book));
        var request = get(BookRestController.BASE_URL).accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].title").value("titel"))
                .andExpect(jsonPath("$[0].blurb").value("blurb"))
                .andExpect(jsonPath("$[0].genre").value("Comic"))
                .andExpect(jsonPath("$[0].author").value("author"))
                .andExpect(jsonPath("$[0].language").value("lang"))
                .andExpect(jsonPath("$[0].publisher").value("pub"))
                .andExpect(jsonPath("$[0].mainCharacter").value("Dieter Bohlen"))
                .andDo(print());
    }

    @Test
    void ensureGetBooksWithQuerystringWithDataDeliversStatusOkAndProperlyPopulatedArray() throws Exception {
        var book = Book.builder()
                .title("titel")
                .blurb("blurb")
                .genre(BookGenre.Comic)
                .author("author")
                .language("lang")
                .publisher("pub")
                .mainCharacter("Dieter Bohlen")
                .build();;
        when(bookService.getBooks()).thenReturn(List.of(book));
        var request = get(BookRestController.BASE_URL).param("titelLike", "titl").accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].title").value("titel"))
                .andExpect(jsonPath("$[0].blurb").value("blurb"))
                .andExpect(jsonPath("$[0].genre").value("Comic"))
                .andExpect(jsonPath("$[0].author").value("author"))
                .andExpect(jsonPath("$[0].language").value("lang"))
                .andExpect(jsonPath("$[0].publisher").value("pub"))
                .andExpect(jsonPath("$[0].mainCharacter").value("Dieter Bohlen"))
                .andDo(print());
    }

    @Test
    void ensureCreateBookHandlesTitleAlreadyExistsProperly() throws Exception {
        String title = "CryForHelp";
        var cmd = new CreateBookCommand(title,"Pennywise",BookGenre.Romance,"pain","Benni","Amis (R) Mutter","blurb");
        when(bookService.addBook(eq(title),any(),any(),any(),any(),any(),any())).thenThrow(BookAlreadyExistsException.forBookTitle(title));
        var request = post(BookRestController.BASE_URL).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(cmd));

        mockMvc.perform(request)
                .andExpect(status().isConflict())
                .andDo(print());
    }


}
