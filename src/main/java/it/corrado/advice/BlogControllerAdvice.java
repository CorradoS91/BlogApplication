package it.corrado.advice;

import it.corrado.error.BlogApiError;
import it.corrado.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;

@ControllerAdvice
@ResponseBody
public class BlogControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BlogApiError handleNotFoundException(NotFoundException exception, HttpServletRequest request){
        BlogApiError error = new BlogApiError();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setPath(request.getRequestURL().toString());
        error.setTimestamp(Instant.now());
        error.setMessage(exception.getMessage());
        return error;
    }

}
