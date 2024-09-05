package it.corrado.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotFoundException extends RuntimeException{
    private Long idNotFound;
    private String nicknameNotFound;
    private String emailNotFound;
    private String message;

}
