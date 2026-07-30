package com.Homework.Collegemanagement.BookService;

import com.Homework.Collegemanagement.BookDTO.BookDTO;
import com.Homework.Collegemanagement.BookRepo.AuthorRepository;
import com.Homework.Collegemanagement.BookRepo.BookRepository;
import com.Homework.Collegemanagement.Entity.Author;
import com.Homework.Collegemanagement.Entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookrepo;
    private final ModelMapper modelMapper;
    private final AuthorRepository authorRepo;

    public BookService( BookRepository bookrepo, ModelMapper modelMapper, AuthorRepository authorRepo) {
        this.bookrepo = bookrepo;
        this.modelMapper = modelMapper;
        this.authorRepo = authorRepo;
    }

    public BookDTO createBook(BookDTO bookDTO) {

        Author author=authorRepo.findById(bookDTO.getAuthorId()).orElseThrow(()-> new IllegalArgumentException("not found"));
        Book newBook=modelMapper.map(bookDTO,Book.class);
        newBook.setAuthor(author);
        return modelMapper.map(newBook,BookDTO.class);
    }

    public List<BookDTO> getAllBooks() {
        List<Book> list=bookrepo.findAll();

        return  list.stream()
                .map(every->modelMapper.map(every,BookDTO.class))
                .toList();

    }

    public BookDTO getBookById(Long id) {
        Book book=bookrepo.findById(id).orElseThrow(()->new IllegalArgumentException("not found"));
        return modelMapper.map(book,BookDTO.class);

    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (bookDTO.getName() != null) {
            book.setName(bookDTO.getName());
        }

        if (bookDTO.getISBN() != null) {
            book.setISBN(bookDTO.getISBN());
        }

        if (bookDTO.getPrice() != null) {
            book.setPrice(bookDTO.getPrice());
        }

        if (bookDTO.getAuthorId() != null) {
            Author author = authorRepo.findById(bookDTO.getAuthorId())
                    .orElseThrow(() -> new RuntimeException("Author not found"));

            book.setAuthor(author);
        }

        Book updatedBook = bookrepo.save(book);

        BookDTO dto = modelMapper.map(updatedBook, BookDTO.class);
        dto.setAuthorId(updatedBook.getAuthor().getId());

        return dto;
    }

    public void deleteBook(Long id) {
        if (!bookrepo.existsById(id)) {
            throw new RuntimeException("Book not found");
        }

        bookrepo.deleteById(id);
    }



}
