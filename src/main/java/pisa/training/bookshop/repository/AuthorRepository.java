package pisa.training.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pisa.training.bookshop.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
