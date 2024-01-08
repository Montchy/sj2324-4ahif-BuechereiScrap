package com.example.buecherrei.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

import java.util.List;

@Builder
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

}
