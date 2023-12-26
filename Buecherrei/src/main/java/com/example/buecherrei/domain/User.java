package com.example.buecherrei.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users")
public class User extends Person{
    public boolean isStudent;
    public boolean isSenior;
    public boolean isMember;
    @OneToMany(cascade = CascadeType.ALL)
    public @NotNull Set<Membership> memberships;
    @ManyToMany(cascade = CascadeType.ALL)
    public @NotNull Set<BorrowedItem> currentlyBorrowed;

    public User(@NotNull @NotEmpty String name, @NotNull @NotEmpty String surname, @Positive int age, @NotNull @NotEmpty String address,
                @NotNull PhoneNumber phoneNumber, @NotNull SocialSecurityNumber socialSecurityNumber, boolean isStudent,
                boolean isSenior, boolean isMember, Set<Membership> memberships, Set<BorrowedItem> currentlyBorrowed) {
        super(name, surname, age, address, phoneNumber, socialSecurityNumber);
        this.isStudent = isStudent;
        this.isSenior = isSenior;
        this.isMember = isMember;
        this.memberships = memberships;
        this.currentlyBorrowed = currentlyBorrowed;
    }
}
