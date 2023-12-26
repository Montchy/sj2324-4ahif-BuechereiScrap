package com.example.buecherrei.persistence.converter;

import com.example.buecherrei.domain.BookGenre;
import com.example.buecherrei.domain.MovieGenre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BookGenreConverterTest {
    private BookGenreConverter converter;

    @BeforeEach
    void setup() {converter = new BookGenreConverter();}

    @ParameterizedTest
    @MethodSource
    void ensureMappingDomainToDBValueWorks(BookGenre givenGenre, String expectedGenre){
        assertThat(converter.convertToDatabaseColumn(givenGenre)).isEqualTo(expectedGenre);
    }

    static Stream<Arguments> ensureMappingDomainToDBValueWorks(){
        return Stream.of(
                Arguments.of(BookGenre.Novel, "Novel"),
                Arguments.of(BookGenre.Biography, "Biography"),
                Arguments.of(BookGenre.Science_Fiction, "Science_Fiction"),
                Arguments.of(BookGenre.Romance, "Romance"),
                Arguments.of(BookGenre.Fantasy, "Fantasy"),
                Arguments.of(BookGenre.Thriller, "Thriller"),
                Arguments.of(BookGenre.Comic, "Comic")
        );
    }

    @ParameterizedTest
    @MethodSource
    void ensureDBValueToDomainWorks(String givenDBValue, BookGenre expectedGenre){
        assertThat(converter.convertToEntityAttribute(givenDBValue)).isEqualTo(expectedGenre);
    }

    static Stream<Arguments> ensureDBValueToDomainWorks(){
        return Stream.of(
                Arguments.of("Novel", BookGenre.Novel),
                Arguments.of("Biography", BookGenre.Biography),
                Arguments.of("Science_Fiction", BookGenre.Science_Fiction),
                Arguments.of("Fantasy", BookGenre.Fantasy),
                Arguments.of("Thriller", BookGenre.Thriller),
                Arguments.of("Comic", BookGenre.Comic),
                Arguments.of("Romance", BookGenre.Romance)
        );
    }
}
