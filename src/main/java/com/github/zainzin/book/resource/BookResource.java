package com.github.zainzin.book.resource;

import com.github.zainzin.book.service.GraphQLService;
import graphql.ExecutionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/rest/books")
@RestController
public class BookResource {

    private final GraphQLService graphQLService;

    public BookResource(GraphQLService graphQLService) {
        this.graphQLService = graphQLService;
    }

    @PostMapping
    public ResponseEntity<?> getAllBooks(@RequestBody String query) {
        ExecutionResult execute = graphQLService.getGraphQL().execute(query);
        return ResponseEntity.ok(execute);
    }
}
