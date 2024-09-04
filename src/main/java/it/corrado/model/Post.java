package it.corrado.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Post")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "POST_ID")
@Table(name="POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="POST_ID")
    private long id;
    @NotBlank
    @NotNull
    @Column(name ="TITLE")
    private String title;
    @NotBlank
    @NotNull
    @Column(name ="SUBTITLE")
    private String subtitle;
    @NotBlank
    @NotNull
    @Column(name ="BODY")
    private String body;
    @Column(name="CREATED_AT")
    LocalDate created_at;
    @Column(name="UPDATED_AT")
    LocalDate updated_at;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FK_USER_ID")
    private User user;
    @ManyToMany(mappedBy = "POST")
    private Set<Tag> tagSet = new HashSet<>();
}
