package com.betrybe.agrix.advice;

import com.betrybe.agrix.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Class GlobalControllerAdvice.
 */
@ControllerAdvice
public class GlobalControllerAdvice {
  @ExceptionHandler
  public ResponseEntity<String> handleNotFound(NotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(exception.getMessage());
  }
}

