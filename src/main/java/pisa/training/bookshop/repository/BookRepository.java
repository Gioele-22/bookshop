package pisa.training.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pisa.training.bookshop.model.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
