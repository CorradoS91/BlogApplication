package it.corrado.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "User")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name="USER_BLOG")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name ="USER_ID")
    private Long id;
    @NotNull
    @NotBlank
    @Column(name="NAME")
    private String name;
    @NotNull
    @NotBlank
    @Column(name="SURNAME")
    private String surname;
    @NotNull
    @NotBlank
    @Column(name="NICKNAME")
    private String nickname;
    @NotNull
    @NotBlank
    @Column(name="EMAIL")
    private String email;

}
