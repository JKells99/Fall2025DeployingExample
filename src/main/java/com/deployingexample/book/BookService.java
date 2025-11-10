package com.deployingexample.book;

import com.deployingexample.author.Author;
import com.deployingexample.author.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;


    public Book saveBook(Book book) {
        return bookRepository.save(book);

    }
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
