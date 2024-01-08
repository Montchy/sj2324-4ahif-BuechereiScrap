package com.example.buecherrei.persistence;

import com.example.buecherrei.domain.Book;
import com.example.buecherrei.domain.BookGenre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest

public class BookRepositoryTest {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void SaveReadTest(){
        Book b = Book.builder()
                .title("titel")
                .blurb("blurb")
                .genre(BookGenre.Comic)
                .author("author")
                .language("lang")
                .publisher("pub")
                .mainCharacter("Dieter Bohlen")
                .build();

        var test = bookRepository.saveAndFlush(b);

        assertThat(test).isSameAs(b);
        assertThat(test.getId()).isSameAs(b.getId());

    }
}
