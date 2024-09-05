package it.corrado.dto;

import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDto {
    private long id;
    private String title;
    private String subtitle;
    private String body;
    private LocalDate created_at;
    private LocalDate updated_at;
    private long fk_user_id;
    private Set<Long> tagIds;
}
