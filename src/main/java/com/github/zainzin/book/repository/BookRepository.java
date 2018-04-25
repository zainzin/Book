package com.github.zainzin.book.repository;

import com.github.zainzin.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
