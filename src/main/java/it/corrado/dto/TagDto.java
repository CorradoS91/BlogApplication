package it.corrado.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TagDto {
    private Integer id;
    private String name;
    private Set<Long> postIds;
}
