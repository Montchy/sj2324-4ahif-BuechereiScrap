package com.example.buecherrei.persistence;

import com.example.buecherrei.TestContainerConfiguration;
import com.example.buecherrei.domain.*;
import org.assertj.core.api.CollectionAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;

import static com.example.buecherrei.TestFixtures.number;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestContainerConfiguration.class)
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Test
    void SaveReadTest() {

        Employee b = Employee.builder()
                .manager(null)
                .employees(Collections.emptyList())
                .jobDesc("dd")
                .isTrainer(false)
                .libraries(Collections.emptyList())
                .trainings(Collections.emptySet())
                .salary(20)
                .name("s")
                .surname("icryy")
                .age(10)
                .address("adwadw")
                .phoneNumber(PhoneNumber.builder()
                        .areaCode(30)
                        .person(null)
                        .localNumber(SerialPhoneNumber.builder().SerialNum(100).build())
                        .countryCode(20)
                        .build())
                .socialSecurityNumber(number())
                .build();

        var test = employeeRepository.saveAndFlush(b);

        assertThat(test).isSameAs(b);
        assertThat(test.getId()).isSameAs(b.getId());

    }
}
