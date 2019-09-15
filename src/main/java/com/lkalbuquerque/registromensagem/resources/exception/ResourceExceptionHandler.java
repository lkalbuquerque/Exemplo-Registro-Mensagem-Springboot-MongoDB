package com.lkalbuquerque.registromensagem.resources.exception;

import com.lkalbuquerque.registromensagem.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    public ResponseEntity<ErroPadrao> objectNotFound (ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(),status.value(),"Não Encontrato",e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }
}
