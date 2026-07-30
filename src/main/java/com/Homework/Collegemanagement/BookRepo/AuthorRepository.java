package com.Homework.Collegemanagement.BookRepo;

import com.Homework.Collegemanagement.Entity.Author;
import com.Homework.Collegemanagement.Entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Modifying
    @Transactional
    @Query("select a from Author a where a.name=:name ")
    Author findAuthorByName(@Param("name") String name);

    @Modifying
    @Transactional
    @Query("select b from Book b where b.author.id=:id")
    List<Book> findBooksByAuthorId(@Param("id") Long id);
}