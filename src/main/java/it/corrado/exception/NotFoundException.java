package it.corrado.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException{
    private Long idNotFound;
    private String nicknameNotFound;
    private String emailNotFound;
    private String message;
}
