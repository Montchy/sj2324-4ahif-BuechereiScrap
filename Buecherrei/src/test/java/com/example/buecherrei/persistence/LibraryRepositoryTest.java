package com.example.buecherrei.persistence;

import com.example.buecherrei.domain.Employee;
import com.example.buecherrei.domain.Library;
import com.example.buecherrei.persistence.LibraryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class LibraryRepositoryTest {
    @Autowired
    private LibraryRepository libraryRepository;

    @Test
    void SaveReadTest(){

        Library b = Library.builder()
                .name("n")
                .borrowedItems(null)
                .manager(Employee.builder()
                        .manager(null)
                        .employees(null)
                        .jobDesc("dd")
                        .isTrainer(false)
                        .libraries(null)
                        .Trainings(null)
                        .salary(20)
                        .build())
                .location("loc")
                .build();

        var test = libraryRepository.saveAndFlush(b);

        assertThat(test).isSameAs(b);
        assertThat(test.getId()).isSameAs(b.getId());


    }
}
