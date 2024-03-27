package com.example.buecherrei.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "books")
public class Book extends AbstractPersistable<Long> {
    public @NotNull @NotEmpty String title;
    public @NotNull @NotEmpty String author;
    public @NotNull BookGenre genre;
    public @NotNull @NotEmpty String language;
    public @NotNull @NotEmpty String mainCharacter;
    public @NotNull @NotEmpty String publisher;
    public @NotNull @NotEmpty String blurb;
    @Column(name = "book_key", unique = true, length = 40, nullable = false )
    private @NotBlank String  key;

}

