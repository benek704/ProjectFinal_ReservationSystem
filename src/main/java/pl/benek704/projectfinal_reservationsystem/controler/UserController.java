package pl.benek704.projectfinal_reservationsystem.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.benek704.projectfinal_reservationsystem.Dao.UserDao;
import pl.benek704.projectfinal_reservationsystem.model.Club;
import pl.benek704.projectfinal_reservationsystem.model.User;
import pl.benek704.projectfinal_reservationsystem.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserRepository userRepository;
    private final UserDao userDao;

    public UserController(UserRepository userRepository, UserDao userDao) {
        this.userRepository = userRepository;
        this.userDao = userDao;
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("User", new User());
        return "/user/add";
    }

    @PostMapping("/addUser")
    public String addUser(Model model, @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("User", new User());
            return "/user/add";
        }
        userDao.addUser(user);
        return "redirect:/";

    }
}
