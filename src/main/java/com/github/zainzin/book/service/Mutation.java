package com.github.zainzin.book.service;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.github.zainzin.book.model.Book;
import com.github.zainzin.book.repository.BookRepository;

import java.time.Instant;

public class Mutation implements GraphQLRootResolver {

    private final BookRepository bookRepository;

    public Mutation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(String title, String publisher, String publishedDate) {
        Book book = new Book(String.valueOf(Instant.now().toEpochMilli()), title, publisher, publishedDate);
        return bookRepository.save(book);
    }
}
