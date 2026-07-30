package com.Homework.Collegemanagement.BookController;


import com.Homework.Collegemanagement.BookDTO.BookDTO;

import com.Homework.Collegemanagement.BookService.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
    @RequestMapping("/books")
    @RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    // Create a new Book
    @PostMapping
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    // Get all Books
    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Get Book by ID
    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    // Update Book
    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable Long id,
                              @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(id, bookDTO);
    }

    // Delete Book
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "Book deleted successfully.";
    }
}

