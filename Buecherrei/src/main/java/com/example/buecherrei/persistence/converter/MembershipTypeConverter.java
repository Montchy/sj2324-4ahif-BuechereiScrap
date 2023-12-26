package com.example.buecherrei.persistence.converter;

import com.example.buecherrei.domain.MembershipType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Optional;

@Converter(autoApply=true)
public class MembershipTypeConverter implements AttributeConverter<MembershipType, String> {

    @Override
    public String convertToDatabaseColumn(MembershipType membershipType) {
        return Optional.ofNullable(membershipType)
                .map(type -> switch (type){
                    case VIP_Membership -> "VIP";
                    case Plus_Membership -> "Plus";
                    case Standard_Membership -> "Standard";
                })
                .orElse(null);
    }

    @Override
    public MembershipType convertToEntityAttribute(String s) {
        return Optional.ofNullable(s)
                .map(type -> switch (type){
                    case "VIP" -> MembershipType.VIP_Membership;
                    case "Plus" -> MembershipType.Plus_Membership;
                    case "Standard" -> MembershipType.Standard_Membership;
                    default -> throw new IllegalArgumentException("Unsupported value '%s' found for %s".formatted(s, MembershipType.class.getSimpleName()));
                })
                .orElse(null);
    }
}
