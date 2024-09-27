package pisa.training.bookshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pisa.training.bookshop.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
