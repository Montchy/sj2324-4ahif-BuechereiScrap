package com.example.buecherrei.persistence;

import com.example.buecherrei.TestContainerConfiguration;
import com.example.buecherrei.domain.*;
import com.example.buecherrei.persistence.LibraryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.time.LocalDate;
import java.util.Collections;

import static com.example.buecherrei.TestFixtures.number;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestContainerConfiguration.class)
public class LibraryRepositoryTest {
    @Autowired
    private LibraryRepository libraryRepository;

    @Test
    void SaveReadTest(){

        Library b = Library.builder()
                .name("n")
                .borrowedItems(Collections.emptySet())
                .manager(Employee.builder()
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
                        .build())
                .location("loc")
                .build();

        var test = libraryRepository.saveAndFlush(b);

        assertThat(test).isSameAs(b);
        assertThat(test.getId()).isSameAs(b.getId());


    }
}
