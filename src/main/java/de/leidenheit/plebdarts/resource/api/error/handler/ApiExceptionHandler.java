package de.leidenheit.plebdarts.resource.api.error.handler;

import de.leidenheit.plebdarts.controller.rest.GameController;
import de.leidenheit.plebdarts.resource.api.error.ApiError;
import de.leidenheit.plebdarts.resource.api.error.exception.GameCreationException;
import de.leidenheit.plebdarts.resource.api.error.exception.GameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackageClasses = GameController.class)
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GameCreationException.class)
    public ResponseEntity<ApiError> handleGameCreationException(GameCreationException gameCreationException) {
        final var apiError = ApiError.builder()
                .setTitle(gameCreationException.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<ApiError> handleGameNotFoundException(GameNotFoundException gameNotFoundException) {
        final var apiError = ApiError.builder()
                .setTitle(gameNotFoundException.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

}
