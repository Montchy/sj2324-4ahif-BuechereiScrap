package com.example.buecherrei.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "socialsecuritynumbers")
public class SocialSecurityNumber extends AbstractPersistable<Long>{
    public @PastOrPresent LocalDate Birtdate;
    public @NotNull RawSocialNumber rawSocialNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;
}
