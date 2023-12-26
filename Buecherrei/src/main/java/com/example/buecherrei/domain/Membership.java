package com.example.buecherrei.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "memberships")
public class Membership implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    public @NotNull User user;
    @Id
    public @FutureOrPresent LocalDate memberTill;

    public @Positive int generalDiscount;
    public @NotNull MembershipType membershipType;
}
