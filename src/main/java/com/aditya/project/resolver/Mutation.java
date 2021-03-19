package com.aditya.project.resolver;

import com.aditya.project.entity.Author;
import com.aditya.project.entity.Book;
import com.aditya.project.repository.AuthorRepository;
import com.aditya.project.repository.BookRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public Author createAuthor(String name, int age) {
        Author author = new Author();
        author.setName(name);
        author.setAge(age);
        return authorRepository.save(author);
    }

    public Book createBook(String title, String description, int authorId) {
        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        book.setAuthor(authorRepository.findById(authorId).orElseThrow(null));
        return bookRepository.save(book);
    }

    public boolean deleteBook(int id) {
        bookRepository.deleteById(id);
        return true;
    }

    public Book updateBook(int id, String title, String description) throws NotFoundException {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isEmpty()) {
            throw new NotFoundException("No book found with id:" + id);
        }
        if (title!=null) {
            book.get().setTitle(title);
        }
        if (description!=null) {
            book.get().setDescription(description);
        }
        return bookRepository.save(book.get());
    }
}
