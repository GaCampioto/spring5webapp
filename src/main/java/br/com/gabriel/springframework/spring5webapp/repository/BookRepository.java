package br.com.gabriel.springframework.spring5webapp.repository;

import br.com.gabriel.springframework.spring5webapp.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
