package com.aditya.project.resolver;

import com.aditya.project.entity.Author;
import com.aditya.project.entity.Book;
import com.aditya.project.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {

    private final AuthorRepository authorRepository;

    public Author getAuthor(Book book) {
        return authorRepository.findById(book.getAuthor().getId()).orElseThrow(null);
    }
}
