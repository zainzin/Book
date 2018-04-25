package com.github.zainzin.book.service;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import com.github.zainzin.book.model.Book;
import com.github.zainzin.book.repository.BookRepository;

import java.util.List;

public class Query implements GraphQLRootResolver {

    private final BookRepository bookRepository;

    public Query(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    public Book oneBook() {
        return bookRepository.getOne("87afhiauhf");
    }


}
