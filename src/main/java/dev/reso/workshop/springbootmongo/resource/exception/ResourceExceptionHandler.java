package dev.reso.workshop.springbootmongo.resource.exception;

import dev.reso.workshop.springbootmongo.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError error = new StandardError(
                System.currentTimeMillis(),
                status.value(),
                "Not Found",
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

}
