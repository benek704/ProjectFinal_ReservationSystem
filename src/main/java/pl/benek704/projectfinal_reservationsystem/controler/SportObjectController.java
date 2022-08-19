package pl.benek704.projectfinal_reservationsystem.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.benek704.projectfinal_reservationsystem.Dao.ClubDao;
import pl.benek704.projectfinal_reservationsystem.Dao.SportObjectDao;
import pl.benek704.projectfinal_reservationsystem.model.SportObject;
import pl.benek704.projectfinal_reservationsystem.repository.ClubRepository;
import pl.benek704.projectfinal_reservationsystem.repository.SportObjectRepository;

import javax.validation.Valid;

@Controller
public class SportObjectController {
    private final SportObjectRepository sportObjectRepository;
    private final SportObjectDao sportObjectDao;
    private final ClubDao clubDao;
    private final ClubRepository clubRepository;

    public SportObjectController(SportObjectRepository sportObjectRepository, SportObjectDao sportObjectDao, ClubDao clubDao, ClubRepository clubRepository) {
        this.sportObjectRepository = sportObjectRepository;
        this.sportObjectDao = sportObjectDao;
        this.clubDao = clubDao;
        this.clubRepository = clubRepository;
    }

    @GetMapping("/addSportObject")
    public String addSportObject(Model model) {
        model.addAttribute("Club", clubRepository.findAll());
        model.addAttribute("sportObject", new SportObject());
        return "sportObject/AddSportObject";
    }

    @PostMapping("/addSportObject")
    public String addSportObject(Model model, @Valid SportObject sportObject, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("Club", clubRepository.findAll());
            System.out.println("some error");
            return "sportObject/AddSportObject";
        }
        sportObjectDao.safeSportObject(sportObject);
        return "redirect:/Clubs";
    }

    @GetMapping("/deleteSportObject/{id}")
    public String deleteSportObject(@PathVariable Long id) {
        sportObjectDao.delete(sportObjectDao.findById(id));
        return "redirect:/Clubs";
    }


}
