package pl.benek704.projectfinal_reservationsystem.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @Future
    private LocalDateTime start;
    private LocalDateTime end;
    @ManyToOne(cascade = CascadeType.MERGE)
    private SportObject sportObject;
}
