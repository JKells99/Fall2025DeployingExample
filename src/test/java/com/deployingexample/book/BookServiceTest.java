package com.deployingexample.book;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    // THIS IS A TEST CLASS FOR BOOK SERVICE
    @Mock
    private BookRepository bookRepository;
    @InjectMocks
    private BookService bookService;

    @Test
    void shouldCreateBookAndReturnSaved() {
        Book input = new Book();
        input.setTitle("Killing Floor");

        Book saved = new Book();
        saved.setId(1L);
        saved.setTitle("Killing Floor");

        when(bookRepository.save(any(Book.class))).thenReturn(saved);


        Book result = bookService.saveBook(input);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Killing Floor", result.getTitle());
        verify(bookRepository).save(input);


    }

}
