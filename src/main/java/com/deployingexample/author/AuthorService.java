package com.deployingexample.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }


    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).get();
    }
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
    public Author updateAuthor(Long id, Author author) {
        author.setId(id);
        return authorRepository.save(author);
    }
}
