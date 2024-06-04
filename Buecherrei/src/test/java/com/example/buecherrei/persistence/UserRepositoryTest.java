package com.example.buecherrei.persistence;

import com.example.buecherrei.TestContainerConfiguration;
import com.example.buecherrei.domain.*;
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
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void SaveReadTest(){
        User b = User.builder()
                .age(18)
                .name("Silvia Beta")
                .address("Secret")
                .isStudent(false)
                .isMember(false)
                .memberships(Collections.emptySet())
                .currentlyBorrowed(Collections.emptySet())
                .isSenior(false)
                .socialSecurityNumber(number())
                .surname("Pens")
                .phoneNumber(PhoneNumber.builder()
                        .areaCode(30)
                        .person(null)
                        .localNumber(SerialPhoneNumber.builder().SerialNum(100).build())
                        .countryCode(20)
                        .build())
                .build();

            var test = userRepository.saveAndFlush(b);

        assertThat(test).isSameAs(b);
        assertThat(test.getId()).isSameAs(b.getId());
    }
}
