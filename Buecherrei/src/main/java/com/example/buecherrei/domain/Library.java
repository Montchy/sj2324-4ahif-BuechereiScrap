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
@Table(name = "libraries")
public class Library extends AbstractPersistable<Long> {

    public @NotNull @NotEmpty String name;
    public @NotNull @NotEmpty String location;

    @ManyToOne(cascade = CascadeType.ALL)
    public Employee manager;

    @OneToMany(cascade = CascadeType.ALL)
    public @NotNull Set<BorrowedItem> borrowedItems;
}
