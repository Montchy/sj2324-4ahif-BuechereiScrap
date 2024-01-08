package com.example.buecherrei.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity

public abstract class Person extends AbstractPersistable<Long> {
    public @NotNull @NotEmpty String name;
    public @NotNull @NotEmpty String surname;
    public @Positive int age;
    public @NotNull @NotEmpty String address;

    @OneToOne(cascade = CascadeType.ALL)
    public @NotNull PhoneNumber phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    public @NotNull SocialSecurityNumber socialSecurityNumber;
}
