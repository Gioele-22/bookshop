package pisa.training.bookshop.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pisa.training.bookshop.model.Book;
import pisa.training.bookshop.model.Publisher;
import pisa.training.bookshop.repository.BookRepository;
import pisa.training.bookshop.repository.PublisherRepository;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;
    @Autowired
    private BookRepository bookRepository;

    public List<Publisher> getAllPublishers(){
        return publisherRepository.findAll();
    }

    public Publisher addPublisher(Publisher publisher){
        return publisherRepository.save(publisher);
    }

    public void deletePublisherById(Long publisherId){
        if(!publisherRepository.existsById(publisherId)){
            throw new EntityNotFoundException("Publisher with id " + publisherId + " not found");
        }
        publisherRepository.deleteById(publisherId);
    }

    public Publisher updatePublisherById(Long publisherId, Publisher updatePublisher){
        return publisherRepository.findById(publisherId).map(publisher -> {
            publisher.setAddress(updatePublisher.getAddress());
            return publisherRepository.save(publisher);
        }).orElseThrow(() -> new EntityNotFoundException("Publisher with id " + publisherId + " not found"));
    }

    /*
    public void addBookToPublisher(Long publisherId, Long bookId){
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new EntityNotFoundException("Publisher with id " + publisherId + " not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book with id " + bookId + " not found"));

        book.setPublisher(publisher);
        publisher.addBook(book);
        bookRepository.save(book);
        publisherRepository.save(publisher);
    }
     */
}


