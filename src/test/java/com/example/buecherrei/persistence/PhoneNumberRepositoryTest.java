package com.example.buecherrei.persistence;

import com.example.buecherrei.TestContainerConfiguration;
import com.example.buecherrei.domain.PhoneNumber;
import com.example.buecherrei.domain.SerialPhoneNumber;
import com.example.buecherrei.persistence.PhoneNumberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestContainerConfiguration.class)
public class PhoneNumberRepositoryTest {
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Test
    void SaveReadTest(){
        PhoneNumber b = PhoneNumber.builder()
                .areaCode(30)
                .person(null)
                .localNumber(SerialPhoneNumber.builder().SerialNum(100).build())
                .countryCode(20)
                .build();

        var test = phoneNumberRepository.saveAndFlush(b);

        assertThat(test).isSameAs(b);
        assertThat(test.getId()).isSameAs(b.getId());
    }
}
