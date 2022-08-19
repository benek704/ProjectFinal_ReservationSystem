package pl.benek704.projectfinal_reservationsystem.model;

import javax.persistence.*;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    private User username;
    @ManyToOne
    private Club name;
    @ManyToOne
    private Timetable timetable;
}
