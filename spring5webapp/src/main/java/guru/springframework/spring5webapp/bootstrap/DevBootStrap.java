package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Repositories.AuthorRepository;
import guru.springframework.spring5webapp.Repositories.BookRepository;
import guru.springframework.spring5webapp.Repositories.PublisherRepository;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
    }

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void initData(){

        Publisher harper=new Publisher("Harper Collins","NJ");
        Author eric=new Author("Eric","Evans");
        Book ddd=new Book("Domain Driven Design","1234");
        ddd.setPublisher(harper);
        ddd.getAuthors().add(eric);
        eric.getBooks().add(ddd);


        Publisher worx=new Publisher("Worx","PA");
        Author rod=new Author("Rod","Jhonson");
        Book noEJB=new Book("JEE without EJB","3456");
        noEJB.setPublisher(worx);
        noEJB.getAuthors().add(rod);
        rod.getBooks().add(noEJB);

        publisherRepository.save(harper);
        publisherRepository.save(worx);

        authorRepository.save(rod);
        authorRepository.save(eric);


        bookRepository.save(ddd);
        bookRepository.save(noEJB);




    }
}
