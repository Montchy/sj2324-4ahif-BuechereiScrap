package com.example.buecherrei.persistence.presentation.api.commands;

import com.example.buecherrei.domain.BookGenre;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CreateBookCommand(
        @NotNull @NotEmpty String title,
        @NotNull @NotEmpty String author,
        @NotNull BookGenre genre,
        @NotNull @NotEmpty String language,
        @NotNull @NotEmpty String mainCharacter,
        @NotNull @NotEmpty String publisher,
        @NotNull @NotEmpty String blurb
) {}
