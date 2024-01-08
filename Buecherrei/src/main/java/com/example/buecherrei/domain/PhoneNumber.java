package com.example.buecherrei.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "phonenumbers")
public class PhoneNumber extends AbstractPersistable<Long> {
    public @Positive int countryCode;
    public @Positive int areaCode;
    public @NotNull SerialPhoneNumber localNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;
}
