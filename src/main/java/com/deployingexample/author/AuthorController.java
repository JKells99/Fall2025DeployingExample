package com.deployingexample.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @PostMapping()
    public ResponseEntity<Author> post(@RequestBody Author author) {
       return new ResponseEntity<>( authorService.saveAuthor(author), HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<Author>> getAll() {
         return new ResponseEntity<>( authorService.getAllAuthors(), HttpStatus.OK);
    }
}
