package com.example.buecherrei.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "librarybooks")
public class LibraryBook extends AbstractPersistable<Long> {
    public boolean isBorrowed;
    public @NotNull @NotEmpty String location;

    @ManyToOne(cascade = CascadeType.ALL)
    public @NotNull Book book;
    //public List<Library> libraries;

    @OneToMany(cascade = CascadeType.ALL)
    public @NotNull Set<BorrowedItem> borrowedItems;
}
