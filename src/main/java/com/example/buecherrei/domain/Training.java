package com.example.buecherrei.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "training")
public class Training implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    public Employee trainee;
    @Id
    public LocalDate trainingStart;

    @ManyToOne(cascade = CascadeType.ALL)
    public Employee trainer;

    public @NotNull @NotEmpty String description;
    public @FutureOrPresent LocalDate trainingEnd;
}
