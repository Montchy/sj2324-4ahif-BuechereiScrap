package com.example.buecherrei.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "librarymovies")
public class LibraryMovie extends AbstractPersistable<Long> {
    public @NotNull @NotEmpty String movieTitle;
    public MovieGenre genre;
    public @NotNull @NotEmpty String actors;
    public @NotNull @NotEmpty String directors;
    public @NotNull @NotEmpty String plotSummary;
    public @Positive int runTime;
    public @NotNull @NotEmpty String rating;
    public @Positive int age;
    public LocalDate releaseDate;
    public @NotNull @NotEmpty String studio;
}
