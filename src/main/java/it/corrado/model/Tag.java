package it.corrado.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name="Tag")
@Table(name="TAG")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "TAG_ID")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="TAG_ID")
    private long id;
    @NotNull
    @NotBlank
    @Column(name="NAME")
    private String name;
    @ManyToMany
    @JoinTable(
            name = "POST_TAG",
            joinColumns = @JoinColumn(name = "POST_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID")
    )
    private Set<Post> postSet = new HashSet<>();
}
