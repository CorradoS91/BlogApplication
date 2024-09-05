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
    private Long id;
    private String title;
    private String subtitle;
    private String body;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Long fkUserId;
    private Set<Long> tagIds;
}
