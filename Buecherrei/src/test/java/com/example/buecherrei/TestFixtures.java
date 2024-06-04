package com.example.buecherrei;

import com.example.buecherrei.domain.*;

import java.time.LocalDate;

public class TestFixtures {


public static final Book book(String title, String author, BookGenre genre, String language, String mainCharacter, String publisher, String blurb){
    return Book.builder()
            .title(title)
            .author(author)
            .genre(genre)
            .language(language)
            .mainCharacter(mainCharacter)
            .publisher(publisher)
            .blurb(blurb)
            .key("key")
            .build();
}



    public static final SocialSecurityNumber number(){
        return SocialSecurityNumber.builder()
                                    .person(null)
                                    .Birtdate(LocalDate.now())
                                    .person(null)
                                    .rawSocialNumber(RawSocialNumber
                                            .builder()
                                            .RawSocialNumber(100)
                                            .build())
                                            .build();
    }




}
