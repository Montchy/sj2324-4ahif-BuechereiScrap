package com.example.buecherrei.persistence;

import com.example.buecherrei.domain.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    void SaveReadTest() {

        Employee b = Employee.builder()
                .manager(null)
                .employees(null)
                .jobDesc("dd")
                .isTrainer(false)
                .libraries(null)
                .Trainings(null)
                .salary(20)
                .build();

        var test = employeeRepository.saveAndFlush(b);

        assertThat(test).isSameAs(b);
        assertThat(test.getId()).isSameAs(b.getId());

    }
}
