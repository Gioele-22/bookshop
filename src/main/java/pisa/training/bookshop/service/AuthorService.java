package pisa.training.bookshop.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pisa.training.bookshop.model.Author;
import pisa.training.bookshop.model.Book;
import pisa.training.bookshop.repository.AuthorRepository;
import pisa.training.bookshop.repository.BookRepository;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author addAuthor(Author author){
        return authorRepository.save(author);
    }

    public void deleteAuthorById(Long authorId){
        if(!authorRepository.existsById(authorId)){
            throw new EntityNotFoundException("Author with id " + authorId + " not found");
        }
        authorRepository.deleteById(authorId);
    }

    /*
    public Author addBooktoAuthor(Long authorId, Long bookId){
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Author with id " + authorId + " not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book with id " + bookId + " not found"));

        author.addBook(book);
        book.addAuthors(author);

        bookRepository.save(book);
        return authorRepository.save(author);
    }
     */
}
