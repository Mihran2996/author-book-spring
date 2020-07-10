package authorbookspring.demo.controller;

import authorbookspring.demo.model.Author;
import authorbookspring.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/")
    public String homePage(ModelMap modelMap) {
        List<Author> all = authorRepository.findAll();
        modelMap.addAttribute("users", all);
        return "home";
    }

    @GetMapping("/bookPage")
    public String bookPage(ModelMap modelMap) {
        return "bookPage";
    }

    @GetMapping("/authorPage")
    public String authorPage(ModelMap modelMap) {
        return "authorPage";
    }
}
