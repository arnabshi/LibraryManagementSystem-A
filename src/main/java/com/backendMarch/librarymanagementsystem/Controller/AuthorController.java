package com.backendMarch.librarymanagementsystem.Controller;

import com.backendMarch.librarymanagementsystem.Entity.Author;
import com.backendMarch.librarymanagementsystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    // chnage to DTO
    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author){

        authorService.addAuthor(author);
        //return "Author added successfully";
        return new ResponseEntity("Author added successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/get_authors")
    public ResponseEntity getAuthors(){
        return new ResponseEntity(authorService.getAuthors(),HttpStatus.FOUND);
    }
}
