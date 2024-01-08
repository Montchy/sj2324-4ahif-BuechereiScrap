package com.example.buecherrei.persistence.converter;

import com.example.buecherrei.domain.MembershipType;
import com.example.buecherrei.domain.MovieGenre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MovieGenreConverterTest {

    private MovieGenreConverter converter;

    @BeforeEach
    void setup() {converter = new MovieGenreConverter();}

    @ParameterizedTest
    @MethodSource
    void ensureMappingDomainToDBValueWorks(MovieGenre givenGenre, String expectedGenre){
        assertThat(converter.convertToDatabaseColumn(givenGenre)).isEqualTo(expectedGenre);
    }

    static Stream<Arguments> ensureMappingDomainToDBValueWorks(){
        return Stream.of(
                Arguments.of(MovieGenre.Action, "Action"),
                Arguments.of(MovieGenre.Comedy, "Comedy"),
                Arguments.of(MovieGenre.Horror, "Horror"),
                Arguments.of(MovieGenre.Romance, "Romance"),
                Arguments.of(MovieGenre.Drama, "Drama")
        );
    }

    @ParameterizedTest
    @MethodSource
    void ensureDBValueToDomainWorks(String givenDBValue, MovieGenre expectedGenre){
        assertThat(converter.convertToEntityAttribute(givenDBValue)).isEqualTo(expectedGenre);
    }

    static Stream<Arguments> ensureDBValueToDomainWorks(){
        return Stream.of(
                Arguments.of("Action", MovieGenre.Action),
                Arguments.of("Comedy", MovieGenre.Comedy),
                Arguments.of("Horror", MovieGenre.Horror),
                Arguments.of("Romance", MovieGenre.Romance),
                Arguments.of("Drama", MovieGenre.Drama)
        );
    }
}
