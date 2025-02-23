package com.assigment2TA.book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookController {
    @Autowired //an annotation for automatic dependency injection
    private BookRepository bookRep;


    // Read operation
    @GetMapping("/books") //adds the GET endpoint
    public ResponseEntity<List<Book>> getAllBooks()
    {
        try {
            List<Book> bookList = new ArrayList<>();
            bookRep.findAll().forEach(bookList::add);

            if (bookList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);//HTTP Status-Code 204: No Content.
            }

            return new ResponseEntity<>(bookList, HttpStatus.OK);//HTTP Status-Code 200: OK.
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//HTTP Status-Code 500: Internal Server Error.
        }
    }

    @GetMapping("/books/{id}") //adds the GET endpoint
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {

        Optional<Book> bookObj = bookRep.findById(id);

        if (bookObj.isPresent()) {
            return new ResponseEntity<>(bookObj.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// HTTP Status-Code 404: Not Found.
        }
    }

    @GetMapping("/books/title/{title}")//adds the GET endpoint for title
    public ResponseEntity<List<Book>> getBooksByTitle(@PathVariable String title) {
        List<Book> books = bookRep.findByTitleContaining(title);

        if (!books.isEmpty()) {
            return new ResponseEntity<>(books, HttpStatus.OK);// HTTP Status-Code 200:OK.
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// HTTP Status-Code 404: Not Found.
        }
    }


    @GetMapping("/books/category/{category}")//adds the GET endpoint for title
    public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable String category) {
        try {
            // Convert category to a Category enum value
            Category categoryEnum = Category.valueOf(category);
            List<Book> books = bookRep.findByCategory(categoryEnum);

            // Always return 200 OK with the list (empty or not)
            return new ResponseEntity<>(books, HttpStatus.OK); // HTTP Status-Code 200
        } catch (IllegalArgumentException e) {
            // Category not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);// HTTP Status-Code 404
        }
    }

    @PostMapping("/books") //adds the POST endpoint
    public ResponseEntity<Book> addBook(@RequestBody Book newBook) {
        try {
            // Save the new book to the repository and store the result in bookObj
            Book bookObj = bookRep.save(newBook);
            return new ResponseEntity<>(bookObj, HttpStatus.CREATED);//HTTP Status-Code 201: Created.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//HTTP Status-Code 500: Internal Server Error.
        }
    }

    @DeleteMapping("/books/{id}")//adds the DELETE endpoint
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        try {
            // Check if a book with the specified ID exists in the repository
            if (bookRep.existsById(id)) {
                bookRep.deleteById(id);// If the book exists, delete it by ID
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // HTTP Status-Code 204: No Content.
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); // HTTP Status-Code 404: Not Found.
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);//HTTP Status-Code 500: Internal Server Error.
        }
    }
}


