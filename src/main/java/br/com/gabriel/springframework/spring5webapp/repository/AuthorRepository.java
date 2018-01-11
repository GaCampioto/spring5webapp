package br.com.gabriel.springframework.spring5webapp.repository;

import br.com.gabriel.springframework.spring5webapp.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>{
}
