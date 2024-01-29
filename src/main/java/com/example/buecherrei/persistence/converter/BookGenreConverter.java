package com.example.buecherrei.persistence.converter;

import com.example.buecherrei.domain.BookGenre;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply=true)
public class BookGenreConverter implements AttributeConverter<BookGenre, String> {
    @Override
    public String convertToDatabaseColumn(BookGenre bookGenre) {
        return Optional.ofNullable(bookGenre)
                .map(genre -> bookGenre.name())
                .orElse(null);
    }

    @Override
    public BookGenre convertToEntityAttribute(String s) {
        return Optional.ofNullable(s)
                .map(BookGenre::valueOf)
                .orElse(null);
    }
}
