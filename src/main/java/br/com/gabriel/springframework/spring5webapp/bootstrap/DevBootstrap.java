package br.com.gabriel.springframework.spring5webapp.bootstrap;


import br.com.gabriel.springframework.spring5webapp.domain.Author;
import br.com.gabriel.springframework.spring5webapp.domain.Book;
import br.com.gabriel.springframework.spring5webapp.domain.Publisher;
import br.com.gabriel.springframework.spring5webapp.repository.AuthorRepository;
import br.com.gabriel.springframework.spring5webapp.repository.BookRepository;
import br.com.gabriel.springframework.spring5webapp.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initializeDatabase();
    }

    private void initializeDatabase() {
        Author eric = new Author("Eric", "Evans");
        Publisher publisherDDD = new Publisher("Publisher 1", "pub 1 st");
        Book  ddd = new Book("Domain Driven Design", "1234", publisherDDD);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(publisherDDD);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher publisherNoEjb = new Publisher("Publisher 2", "pub 2 st");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisherNoEjb );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(publisherNoEjb);
        bookRepository.save(noEJB);
    }
}
