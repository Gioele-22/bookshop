package pisa.training.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pisa.training.bookshop.model.Author;
import pisa.training.bookshop.service.AuthorService;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping
    public Author adAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }

    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delteAuthor(@PathVariable long authorId){
        authorService.deleteAuthorById(authorId);
    }
}
