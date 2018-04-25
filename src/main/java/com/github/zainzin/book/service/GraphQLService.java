package com.github.zainzin.book.service;

import com.github.zainzin.book.model.Book;
import com.github.zainzin.book.repository.BookRepository;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import com.coxautodev.graphql.tools.SchemaParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GraphQLService {

    private GraphQL graphQL;
    private final BookRepository bookRepository;

    @Autowired
    public GraphQLService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostConstruct
    private void initGraphQLSchema() {
        GraphQLSchema graphQLSchema = SchemaParser
                .newParser()
                .file("book.graphql")
                .resolvers(new Query(bookRepository), new Mutation(bookRepository))
                .build()
                .makeExecutableSchema();

        graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }

    @PostConstruct
    private void loadData() {
        bookRepository.save(new Book("213mk21f", "Test1", "Tester1", "11/11/2015"));
        bookRepository.save(new Book("sdv234mn", "Test2", "Tester2", "11/11/2015"));
        bookRepository.save(new Book("324kfkwe", "Test3", "Tester3", "11/11/2015"));
    }

}
