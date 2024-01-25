package com.example.buecherrei.persistence.presentation.api.advices;

import com.example.buecherrei.service.exceptions.BookAlreadyExistsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class GlobalControllerAdvice {
@ExceptionHandler(BookAlreadyExistsException.class)
@ResponseStatus(HttpStatus.CONFLICT)
public void handleBookAlreadyExistsException(BookAlreadyExistsException e){
    log.warn("A {} has occurred: {}", e.getClass().getSimpleName(), e.getMessage());
}
}
