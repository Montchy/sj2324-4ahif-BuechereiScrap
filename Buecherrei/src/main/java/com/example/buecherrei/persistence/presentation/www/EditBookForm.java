package com.example.buecherrei.persistence.presentation.www;

import com.example.buecherrei.domain.BookGenre;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record EditBookForm(
        @NotNull @NotEmpty String language,
        @NotNull @NotEmpty String blurb
) {
    public static EditBookForm init() {
        return new EditBookForm("", "");
    }
}
