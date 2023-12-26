package com.example.buecherrei.persistence.converter;

import com.example.buecherrei.domain.MovieGenre;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply=true)
public class MovieGenreConverter implements AttributeConverter<MovieGenre, String> {
    @Override
    public String convertToDatabaseColumn(MovieGenre movieGenre) {
        return Optional.ofNullable(movieGenre)
                .map(genre -> movieGenre.name())
                .orElse(null);
    }

    @Override
    public MovieGenre convertToEntityAttribute(String s) {
        return Optional.ofNullable(s)
                .map(MovieGenre::valueOf)
                .orElse(null);
    }
}

