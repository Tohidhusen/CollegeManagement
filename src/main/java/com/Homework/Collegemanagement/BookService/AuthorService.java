package com.Homework.Collegemanagement.BookService;

import com.Homework.Collegemanagement.BookDTO.AuthorDTO;
import com.Homework.Collegemanagement.BookDTO.BookDTO;
import com.Homework.Collegemanagement.BookRepo.AuthorRepository;
import com.Homework.Collegemanagement.Entity.Author;
import com.Homework.Collegemanagement.Entity.Book;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    public AuthorService(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author=modelMapper.map(authorDTO,Author.class);
        Author updatedauthor =authorRepository.save(author);
        return modelMapper.map(updatedauthor,AuthorDTO.class);
    }

    public List<AuthorDTO> getAllAuthors() {
        List<Author> list  = authorRepository.findAll();

        return list.stream()
                .map(every->modelMapper.map(every,AuthorDTO.class))
                .toList();

    }

    public AuthorDTO updateAuthor(Long id, AuthorDTO authorDTO) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        existingAuthor.setName(authorDTO.getName());


        Author updatedAuthor = authorRepository.save(existingAuthor);

        return modelMapper.map(updatedAuthor, AuthorDTO.class);


    }

    public AuthorDTO getAuthorById(Long id) {
          Author author =authorRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Author not found"));
          return modelMapper.map(author,AuthorDTO.class);
    }

    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new RuntimeException("Book not found");
        }
        authorRepository.deleteById(id);
    }

    public AuthorDTO findByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        Author author = authorRepository.findAuthorByName(name);
        if (author == null) {
            throw new EntityNotFoundException("Author with name '" + name + "' not found");
        }
        return modelMapper.map(author, AuthorDTO.class);
    }

    public List<BookDTO> findBookByAuthorId(Long id) {
        List<Book> books = authorRepository.findBooksByAuthorId(id);
        return books.stream()
                .map(book -> modelMapper.map(book, BookDTO.class))
                .toList();
    }
}
