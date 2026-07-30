package com.Homework.Collegemanagement.BookController;

import com.Homework.Collegemanagement.BookDTO.AuthorDTO;
import com.Homework.Collegemanagement.BookDTO.BookDTO;
import com.Homework.Collegemanagement.BookService.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    // Create Author
    @PostMapping
    public AuthorDTO createAuthor(@RequestBody AuthorDTO authorDTO) {
        return authorService.createAuthor(authorDTO);
    }

    // Get All Authors
    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    // Get Author By id
    @GetMapping("/{id}")
    public AuthorDTO getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    // Update Author
    @PutMapping("/{id}")
    public AuthorDTO updateAuthor(@PathVariable Long id,
                                  @RequestBody AuthorDTO authorDTO) {
        return authorService.updateAuthor(id, authorDTO);
    }

    // Delete Author
    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "Author deleted successfully.";
    }
    @GetMapping("/name/{name}")
    public AuthorDTO findauthorByName(@PathVariable String name){
        return authorService.findByName(name);
    }
    @GetMapping("/{id}/books")
    public  List<BookDTO> findBookByAuthorId(@PathVariable Long id){
        return authorService.findBookByAuthorId(id);
    }
}