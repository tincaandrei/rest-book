package org.agoncal.quarkus.starting;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository repository;
    @Inject
    Logger logger;

    @GET
    public List<Book> getAllBooks() {
        logger.info("Returns all books \n");
        return repository.getAllBooks();
    }
    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int getAllBooksSize(){
        logger.info("Returns nr of books \n");
        return repository.getAllBooks().size();
    }

    @GET
    @Path("/{id}")
    public Optional<Book> getBook(@PathParam("id") int id){
        logger.info("Returns the book with id " + id + "\n");
        return repository.getBook(id);
    }
}
