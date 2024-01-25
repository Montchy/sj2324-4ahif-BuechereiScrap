package com.example.buecherrei;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestContainerConfiguration.class)
class BuecherreiApplicationTests {
    @Test
    void contextLoads() {
    }

    @Test
    void verifyAlive(){
        assertThat(true).isTrue();
    }

}
