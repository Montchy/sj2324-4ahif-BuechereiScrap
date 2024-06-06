package com.example.buecherrei.persistence.presentation.www;

import com.example.buecherrei.domain.BookGenre;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateBookForm(
        @NotNull @NotEmpty String titel,
        @NotNull @NotEmpty String author,
        @NotNull BookGenre genre,
        @NotNull @NotEmpty String language,
        @NotNull @NotEmpty String mainCharacter,
        @NotNull @NotEmpty String publisher,
        @NotNull @NotEmpty String blurb
) {
    public static CreateBookForm init() {
        return new CreateBookForm("", "", BookGenre.valueOf("") , "", "", "", "");
    }
}
