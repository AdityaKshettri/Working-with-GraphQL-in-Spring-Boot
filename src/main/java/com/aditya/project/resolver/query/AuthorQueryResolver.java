package com.aditya.project.resolver.query;

import com.aditya.project.entity.Author;
import com.aditya.project.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorQueryResolver implements GraphQLQueryResolver {

    private final AuthorRepository repository;

    public List<Author> findAllAuthors() {
        return repository.findAll();
    }

    public long countAuthors() {
        return repository.count();
    }
}
