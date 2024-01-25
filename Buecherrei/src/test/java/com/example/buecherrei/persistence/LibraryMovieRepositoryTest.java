package com.example.buecherrei.persistence;

import com.example.buecherrei.TestContainerConfiguration;
import com.example.buecherrei.domain.LibraryMovie;
import com.example.buecherrei.domain.MovieGenre;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestContainerConfiguration.class)
public class LibraryMovieRepositoryTest {
    @Autowired
    private LibraryMovieRepository libraryBookRepository;

    @Test
    void SaveReadTest(){
        LibraryMovie b = LibraryMovie.builder()
                .age(18)
                .genre(MovieGenre.Romance)
                .actors("Christian Gray")
                .movieTitle("50 Shades of Oak")
                .directors("Amelie Roggenbauer")
                .rating("1")
                .releaseDate(LocalDate.now())
                .plotSummary("Problems")
                .studio("Spengerhansa")
                .runTime(280)
                .build();

        var test = libraryBookRepository.saveAndFlush(b);

        assertThat(test).isSameAs(b);
        assertThat(test.getId()).isSameAs(b.getId());


    }
}
