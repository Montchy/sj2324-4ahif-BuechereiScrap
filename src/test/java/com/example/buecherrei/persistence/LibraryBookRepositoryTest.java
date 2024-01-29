package com.example.buecherrei.persistence;

import com.example.buecherrei.TestContainerConfiguration;
import com.example.buecherrei.domain.Book;
import com.example.buecherrei.domain.BookGenre;
import com.example.buecherrei.domain.LibraryBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestContainerConfiguration.class)
public class LibraryBookRepositoryTest {
    @Autowired
    private LibraryBookRepository libraryBookRepository;

    @Test
    void SaveReadTest(){
        LibraryBook b = LibraryBook.builder()
                .book(Book.builder()
                        .title("titel")
                        .blurb("blurb")
                        .genre(BookGenre.Comic)
                        .author("author")
                        .language("lang")
                        .publisher("pub")
                        .mainCharacter("Dieter Bohlen")
                        .build())
                .isBorrowed(false)
                .location("Wien")
                .borrowedItems(Collections.emptySet())
                .build();

        var test = libraryBookRepository.saveAndFlush(b);

        assertThat(test).isSameAs(b);
        assertThat(test.getId()).isSameAs(b.getId());
    }

}
