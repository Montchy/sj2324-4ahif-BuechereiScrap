package com.example.buecherrei.domain;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder

@Embeddable
public class SerialPhoneNumber {
    public @Positive int SerialNum;
}
