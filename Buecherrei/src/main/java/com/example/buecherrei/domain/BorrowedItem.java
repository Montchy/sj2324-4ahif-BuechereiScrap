package com.example.buecherrei.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "borroweditems")
public class BorrowedItem extends AbstractPersistable<Long> {
    @ManyToOne(cascade = CascadeType.ALL)
    public @Nullable LibraryBook borrowedBook;
    @ManyToOne(cascade = CascadeType.ALL)
    public @Nullable LibraryMovie borrowedmovie;

    @ManyToOne(cascade = CascadeType.ALL)
    public @NotNull Library library;

    public LocalDate borrowedDate;
    public LocalDate dueDate;
    public @NotNull @NotEmpty String returnPolicy;

    @ManyToMany(cascade = CascadeType.ALL)
    public Set<User> user;
}
