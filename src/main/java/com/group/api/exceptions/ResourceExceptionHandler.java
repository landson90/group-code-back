package com.group.api.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ResourceExceptionHandler {


    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<ErroPadrao> objectNotFound(ObjetoNaoEncontradoException e,
                                                     HttpServletRequest request) {

        ErroPadrao err = new ErroPadrao(HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(ProjetoNaoPodeSerApagadoException.class)
    public ResponseEntity<ErroPadrao> objectNotFound(ProjetoNaoPodeSerApagadoException e,
                                                     HttpServletRequest request) {

        ErroPadrao err = new ErroPadrao(HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }


}
