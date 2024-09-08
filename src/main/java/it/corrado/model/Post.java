package it.corrado.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Post")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name="POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="POST_ID")
    private Long id;
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
    @CreationTimestamp
    @Column(name="CREATED_AT")
    private LocalDate createdAt;
    @UpdateTimestamp
    @Column(name="UPDATED_AT")
    private LocalDate updatedAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="FK_USER_ID")
    private User user;
    @ManyToMany(mappedBy = "post")
    private Set<Tag> tagSet = new HashSet<>();
}
