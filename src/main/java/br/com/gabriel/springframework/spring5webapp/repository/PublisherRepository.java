package br.com.gabriel.springframework.spring5webapp.repository;

import br.com.gabriel.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long>{
}
