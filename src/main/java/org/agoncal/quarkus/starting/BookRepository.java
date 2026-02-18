package org.agoncal.quarkus.starting;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "books.genre", defaultValue = "books.istorie")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
                new Book(1, "istoria romaniei", "Costel", 1907,genre),
                new Book(1, "istoria Fotbalului", "Alex", 1907,genre),
                new Book(1, "istoria Gastronomiei", "Josh", 1907,genre),
                new Book(1, "istoria Bmw", "Gertrud", 1907,genre)
        );
    }




    public Optional<Book> getBook(int id){
        return getAllBooks().stream().filter(book -> book.id == id).findFirst();
    }
}

