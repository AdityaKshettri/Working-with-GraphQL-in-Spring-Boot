package com.aditya.project.resolver.query;

import com.aditya.project.entity.Book;
import com.aditya.project.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookQueryResolver implements GraphQLQueryResolver {

    private final BookRepository repository;

    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    public long countBooks() {
        return repository.count();
    }
}
