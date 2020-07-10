package authorbookspring.demo.controller;

import authorbookspring.demo.model.Author;
import authorbookspring.demo.model.Gender;
import authorbookspring.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AuthorController {
    private int userId;
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/author")
    public String authorPage(ModelMap modelMap) {
        List<Author> all = authorRepository.findAll();
        modelMap.addAttribute("users", all);
        return "authorPage";
    }

    @PostMapping("/addAuthor")
    public String saveAuthor(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/";

    }
    @GetMapping("/deleteAuthor")
    public String deleteById(@RequestParam("id") int id) {
        authorRepository.deleteById(id);
        return "redirect:/author";
    }
    @GetMapping("/updateA")
    public String updateAuthorPage(@RequestParam("id") int id) {
        userId = id;
        return "updateAuthorPage";
    }
    @PostMapping("/updateAuther")
    public String findByIdAndUpdate(@RequestParam("name") String name, @RequestParam("surname") String surname,
                         @RequestParam("email") String email, @RequestParam("gender") String gender,
                         @RequestParam("password") String password, @RequestParam("bio") String bio) {
        Author auther = authorRepository.getOne(userId);
        auther.setName(name);
        auther.setSurname(surname);
        auther.setEmail(email);
        auther.setGender(Gender.valueOf(gender));
        auther.setPassword(password);
        auther.setBio(bio);
        authorRepository.save(auther);
        return "redirect:/author";
    }

}
