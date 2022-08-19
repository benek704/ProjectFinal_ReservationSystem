package pl.benek704.projectfinal_reservationsystem.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String adres;
    @NotBlank
    private String city;
    @NotBlank
    private String password;
    @Email
    private String email;
    private String information;
    @ManyToOne
    private Sport sport;

}
