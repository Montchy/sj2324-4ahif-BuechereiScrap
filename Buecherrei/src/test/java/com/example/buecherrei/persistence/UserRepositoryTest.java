package com.example.buecherrei.persistence;

import com.example.buecherrei.domain.PhoneNumber;
import com.example.buecherrei.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
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
                .memberships(null)
                .currentlyBorrowed(null)
                .isSenior(false)
                .surname("Pens")
                .phoneNumber(PhoneNumber.builder()
                        .areaCode(30)
                        .person(null)
                        .localNumber(null)
                        .countryCode(20)
                        .build())
                .build();

            var test = userRepository.saveAndFlush(b);

        assertThat(test).isSameAs(b);
        assertThat(test.getId()).isSameAs(b.getId());
    }
}
