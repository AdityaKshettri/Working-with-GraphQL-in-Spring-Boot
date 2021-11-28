package com.aditya.project.resolver.mutation;

import com.aditya.project.entity.Author;
import com.aditya.project.repository.AuthorRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorMutationResolver implements GraphQLMutationResolver {

    private final AuthorRepository repository;

    public Author createAuthor(String name, int age) {
        Author author = new Author(name, age);
        return repository.save(author);
    }

    public boolean deleteAuthor(Long id) {
        repository.deleteById(id);
        return true;
    }

    public Author updateAuthor(Long id, String name, int age) throws NotFoundException {
        Author author = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("No author found with id : " + id));
        if (name != null) {
            author.setName(name);
        }
        if (age != 0) {
            author.setAge(age);
        }
        return repository.save(author);
    }
}
