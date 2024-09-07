package it.corrado.dto;

import lombok.*;

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
    private Long fkUserID;
    private Set<Long> tagIds;
}
