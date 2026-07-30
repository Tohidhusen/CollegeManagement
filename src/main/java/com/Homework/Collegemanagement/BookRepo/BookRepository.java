package com.Homework.Collegemanagement.BookRepo;

import com.Homework.Collegemanagement.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}