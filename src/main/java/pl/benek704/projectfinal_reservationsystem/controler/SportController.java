package pl.benek704.projectfinal_reservationsystem.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.benek704.projectfinal_reservationsystem.Dao.SportDao;

@Controller
public class SportController {
    private final SportDao sportDao;

    public SportController(SportDao sportDao) {
        this.sportDao = sportDao;
    }

    @GetMapping("/Sports")
    public String allSports(Model model) {
        model.addAttribute("Sport", sportDao.findAllSports());
        return "sport/allSports";
    }
}
