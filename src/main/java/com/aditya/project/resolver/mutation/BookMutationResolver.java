package com.aditya.project.resolver.mutation;

import com.aditya.project.entity.Author;
import com.aditya.project.entity.Book;
import com.aditya.project.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookMutationResolver implements GraphQLMutationResolver {

    private final BookRepository repository;

    public Book createBook(String title, String description, Long authorId) {
        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        book.setAuthor(new Author(authorId));
        return repository.save(book);
    }

    public boolean deleteBook(Long id) {
        repository.deleteById(id);
        return true;
    }

    public Book updateBook(Long id, String title, String description) throws NotFoundException {
        Book book = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No book found with id : " + id));
        if (title != null) {
            book.setTitle(title);
        }
        if (description != null) {
            book.setDescription(description);
        }
        return repository.save(book);
    }
}
