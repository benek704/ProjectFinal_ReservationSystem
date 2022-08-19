package pl.benek704.projectfinal_reservationsystem.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.benek704.projectfinal_reservationsystem.Dao.ReservationDao;
import pl.benek704.projectfinal_reservationsystem.Dao.SportObjectDao;
import pl.benek704.projectfinal_reservationsystem.Dao.UserDao;
import pl.benek704.projectfinal_reservationsystem.model.Club;
import pl.benek704.projectfinal_reservationsystem.model.Reservation;
import pl.benek704.projectfinal_reservationsystem.repository.ReservationRepository;
import pl.benek704.projectfinal_reservationsystem.repository.SportObjectRepository;
import pl.benek704.projectfinal_reservationsystem.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class ReservationController {
    private final ReservationRepository reservationRepository;
    private final ReservationDao reservationDao;
    private final SportObjectDao sportObjectDao;
    private final SportObjectRepository sportObjectRepository;
    private final UserRepository userRepository;
    private final UserDao userDao;

    public ReservationController(ReservationRepository reservationRepository, ReservationDao reservationDao, SportObjectDao sportObjectDao, SportObjectRepository sportObjectRepository, UserRepository userRepository, UserDao userDao) {
        this.reservationRepository = reservationRepository;
        this.reservationDao = reservationDao;
        this.sportObjectDao = sportObjectDao;
        this.sportObjectRepository = sportObjectRepository;
        this.userRepository = userRepository;
        this.userDao = userDao;
    }

    @GetMapping("/Reservations")
    public String Reservations(Model model) {
        model.addAttribute("Reservation", reservationRepository.findAll());
        return "/reservation/all";
    }

    @GetMapping("/addReservations")
    public String addReservations(Model model) {

        model.addAttribute("SportObject", sportObjectRepository.findAll());
        model.addAttribute("User", userRepository.findAll());
        model.addAttribute("reservation", new Reservation());
        return "reservation/add";
    }

    @PostMapping("/addReservations")
    public String addReservations(Model model, @Valid Reservation reservation, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("SportObject", sportObjectRepository.findAll());
            model.addAttribute("User", userRepository.findAll());
            System.out.println("some error");
            return "reservation/add";
        }
        reservationDao.addReservation(reservation);
        return "redirect:/Reservations";
    }

    @GetMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationDao.delete(reservationDao.findById(id));
        return "redirect:/Reservations";
    }

}
