package com.example.buecherrei.persistence.converter;

import com.example.buecherrei.domain.MembershipType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class MembershipTypeConverterTest {
    private MembershipTypeConverter converter;

    @BeforeEach
    void setup() {converter = new MembershipTypeConverter();}

    @ParameterizedTest
    @MethodSource
    void ensureMappingDomainToDBValueWorks(MembershipType givenType, String expectedType){
        assertThat(converter.convertToDatabaseColumn(givenType)).isEqualTo(expectedType);
    }

    static Stream<Arguments> ensureMappingDomainToDBValueWorks(){
        return Stream.of(
                Arguments.of(MembershipType.Plus_Membership, "Plus"),
                Arguments.of(MembershipType.Standard_Membership, "Standard"),
                Arguments.of(MembershipType.VIP_Membership, "VIP")
        );
    }

    @ParameterizedTest
    @MethodSource
    void ensureDBValueToDomainWorks(String givenDBValue, MembershipType expectedType){
        assertThat(converter.convertToEntityAttribute(givenDBValue)).isEqualTo(expectedType);
    }

    static Stream<Arguments> ensureDBValueToDomainWorks(){
        return Stream.of(
                Arguments.of("Plus", MembershipType.Plus_Membership),
                Arguments.of("Standard", MembershipType.Standard_Membership),
                Arguments.of("VIP", MembershipType.VIP_Membership)
        );
    }
}
