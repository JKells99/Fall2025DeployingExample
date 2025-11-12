// java
package com.deployingexample.author;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @Test
    void shouldCreateAuthorAndReturnSaved() {
        Author input = new Author();
        input.setName("Alice");

        Author saved = new Author();
        saved.setId(1L);
        saved.setName("Alice");

        when(authorRepository.save(any(Author.class))).thenReturn(saved);


        Author result = authorService.saveAuthor(input);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("Alice", result.getName());
        verify(authorRepository).save(input);
    }

    @Test
    void shouldFindAuthorById() {
        Author existing = new Author();
        existing.setId(2L);
        existing.setName("Bob");

        when(authorRepository.findById(2L)).thenReturn(Optional.of(existing));


        Author result = authorService.getAuthorById(2L);

        assertNotNull(result);
        assertEquals(2L, result.getId());
        assertEquals("Bob", result.getName());
        verify(authorRepository).findById(2L);
    }
}
