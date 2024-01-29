package com.example.buecherrei.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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

}
