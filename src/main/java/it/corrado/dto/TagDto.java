package it.corrado.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TagDto {
    private Long id;
    private String name;
    private Set<Long> postIds = new HashSet<>();
}
