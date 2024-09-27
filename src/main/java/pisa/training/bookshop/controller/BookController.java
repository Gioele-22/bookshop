package pisa.training.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pisa.training.bookshop.model.Book;
import pisa.training.bookshop.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping("/{bookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long bookId){
        bookService.deleteBookById(bookId);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable Long bookId, @RequestBody Book updateBook){
        return bookService.updateBookById(bookId, updateBook);
    }

    @PutMapping("/{bookId}/publishers/{publisherId}")
    public Book addPublisherToBook(@PathVariable Long bookId,@PathVariable Long publisherId){
        return bookService.addPublisherToBook(bookId,publisherId);
    }

    @PutMapping("/{bookId}/authors/{authorId}")
    public Book addAuthorToBook(@PathVariable Long bookId,@PathVariable Long authorId){
        return bookService.addAuthorToBook(bookId,authorId);
    }
}
