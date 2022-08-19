package pl.benek704.projectfinal_reservationsystem.controler;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.benek704.projectfinal_reservationsystem.Dao.ClubDao;
import pl.benek704.projectfinal_reservationsystem.Dao.SportDao;
import pl.benek704.projectfinal_reservationsystem.Dao.SportObjectDao;
import pl.benek704.projectfinal_reservationsystem.model.Club;
import pl.benek704.projectfinal_reservationsystem.repository.ClubRepository;

import javax.validation.Valid;

@Controller
public class ClubController {
    private final ClubDao clubDao;
    private final ClubRepository clubRepository;
    private final SportDao sportDao;
    private final SportObjectDao sportObjectDao;

    public ClubController(ClubDao clubDao, ClubRepository clubRepository, SportDao sportDao, SportObjectDao sportObjectDao) {
        this.clubDao = clubDao;
        this.clubRepository = clubRepository;
        this.sportDao = sportDao;
        this.sportObjectDao = sportObjectDao;
    }

    @GetMapping("/Clubs")
    public String displayAllClubs(Model model) {
        model.addAttribute("Club", clubDao.findAllClubs());
        return "club/allClubs";

    }

    @GetMapping("/addClub")
    public String addClub(Model model) {
        model.addAttribute("Sport", sportDao.findAllSports());
        model.addAttribute("club", new Club());
        return "club/add";
    }

    @PostMapping("/addClub")
    public String addClub(Model model, @Valid Club club, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("Sport", sportDao.findAllSports());
            System.out.println("some error");
            return "club/add";
        }
        clubDao.safeClub(club);
        return "redirect:/Clubs";
    }

    @GetMapping("/Clubs/{id}")
    public String displayClubsBySport(Model model, @PathVariable Long id) {
        model.addAttribute("Club", clubDao.findAllClubsBySport(id));
        model.addAttribute("Sport", sportDao.findAllSports());
        return "sport/clubBySport";
    }

    @GetMapping("/clubInfo/{id}")
    public String clubInfo(Model model, @PathVariable Long id) {
        model.addAttribute("Club", clubDao.findById(id));
        model.addAttribute("SportObject", sportObjectDao.findAllSportsObjectsByClub(id));
        return "club/infoClub";
    }

    @GetMapping("/deleteClub/{id}")
    public String deleteClub(@PathVariable Long id) {
        clubDao.delete(clubDao.findById(id));
        return "redirect:/Clubs";
    }
}
