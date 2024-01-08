package com.example.buecherrei.persistence;

import com.example.buecherrei.domain.Book;
import com.example.buecherrei.domain.BookGenre;
import com.example.buecherrei.domain.BorrowedItem;
import com.example.buecherrei.domain.LibraryBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class BorrowedItemRepositoryTest {
    @Autowired
    private BorrowedItemRepository borrowedItemRepository;

    @Test
    void SaveReadTest(){
        BorrowedItem b = BorrowedItem.builder()
                .borrowedBook(LibraryBook.builder()
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
                        .borrowedItems(null)
                        .build())
                .borrowedDate(LocalDate.now())
                .build();


        var test = borrowedItemRepository.save(b);

        assertThat(test).isSameAs(b);
        assertThat(test.getId()).isSameAs(b.getId());
    }
}
