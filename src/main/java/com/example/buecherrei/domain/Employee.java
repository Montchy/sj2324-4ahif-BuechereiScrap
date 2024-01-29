package com.example.buecherrei.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.util.Set;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "employees")
public class Employee extends Person {
    public long salary;
    public String jobDesc;
    @ManyToOne(cascade = CascadeType.ALL)
    public @Nullable Employee manager;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Employee> employees;

    @OneToMany(cascade = CascadeType.ALL)
    public Set<Training> Trainings;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Library> libraries;

    public boolean isTrainer;

    @Builder
    public Employee(@NotNull @NotEmpty String name, @NotNull @NotEmpty String surname, @Positive int age, @NotNull @NotEmpty String address, @NotNull PhoneNumber phoneNumber, @NotNull SocialSecurityNumber socialSecurityNumber, long salary, String jobDesc, Employee manager, List<Employee> employees, Set<Training> trainings, List<Library> libraries, boolean isTrainer) {
        super(name, surname, age, address, phoneNumber, socialSecurityNumber);
        this.salary = salary;
        this.jobDesc = jobDesc;
        this.manager = manager;
        this.employees = employees;
        Trainings = trainings;
        this.libraries = libraries;
        this.isTrainer = isTrainer;
    }
}

