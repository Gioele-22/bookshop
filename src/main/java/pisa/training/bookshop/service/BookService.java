package pisa.training.bookshop.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pisa.training.bookshop.model.Author;
import pisa.training.bookshop.model.Book;
import pisa.training.bookshop.model.Publisher;
import pisa.training.bookshop.repository.AuthorRepository;
import pisa.training.bookshop.repository.BookRepository;
import pisa.training.bookshop.repository.PublisherRepository;

import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }


    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBookById(Long bookId){
        if(!bookRepository.existsById(bookId)){
            throw new EntityNotFoundException("Book with id " + bookId + " not found");
        }
        bookRepository.deleteById(bookId);
    }

    public Book updateBookById(Long bookId, Book updateBook){
        return bookRepository.findById(bookId).map(book -> {
            book.setQuantity(updateBook.getQuantity());
            return bookRepository.save(book);
        }).orElseThrow(() -> new EntityNotFoundException("Book with id " + bookId + " not found"));
    }

    public Book addAuthorToBook(Long bookId, Long authorId){
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book with id " + bookId + " not found"));
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Author with id " + authorId + " not found"));

        book.addAuthors(author);
        author.addBook(book);
        authorRepository.save(author);
        return bookRepository.save(book);
    }

    public Book addPublisherToBook(Long bookId, Long publisherId){
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book with id " + bookId + " not found"));
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new EntityNotFoundException("Publisher with id " + publisherId + " not found"));

        book.setPublisher(publisher);
        publisher.addBook(book);
        publisherRepository.save(publisher);
        return bookRepository.save(book);
    }
}
