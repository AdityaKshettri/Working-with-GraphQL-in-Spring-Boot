package com.aditya.project.resolver;

import com.aditya.project.entity.Author;
import com.aditya.project.entity.Book;
import com.aditya.project.repository.AuthorRepository;
import com.aditya.project.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public long countAuthors() {
        return authorRepository.count();
    }
}
