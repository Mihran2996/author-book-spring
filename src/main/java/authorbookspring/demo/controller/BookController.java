package authorbookspring.demo.controller;

import authorbookspring.demo.model.Author;
import authorbookspring.demo.model.Book;
import authorbookspring.demo.repository.AuthorRepository;
import authorbookspring.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {
    private int bookId;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/book")
    public String bookPage(ModelMap modelMap) {
        List<Book> all = bookRepository.findAll();
        modelMap.addAttribute("books", all);
        return "bookPage";
    }

    @PostMapping("/addBook")
    public String saveBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

    @GetMapping("/deleteBook")
    public String deleteById(@RequestParam("id") int id) {
        bookRepository.deleteById(id);
        return "redirect:/book";
    }

    @GetMapping("/updateB")
    public String updateAuthorPage(@RequestParam("id") int id,ModelMap modelMap) {
        List<Author> all = authorRepository.findAll();
        modelMap.addAttribute("users",all);
        bookId = id;
        return "updateBookPage";
    }
@PostMapping("/updateBook")
public String findByIdAndUpdate(@ModelAttribute Book book) {
        Book one = bookRepository.getOne(bookId);
        if(one!=null){
            bookRepository.deleteById(bookId);
            bookRepository.save(book);
        }
    return "redirect:/book";
}
}
