package it.corrado.dto;

import it.corrado.model.Post;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String name;
    private String surname;
    private String nickname;
    private String email;
    private List<Post> postList;
}
