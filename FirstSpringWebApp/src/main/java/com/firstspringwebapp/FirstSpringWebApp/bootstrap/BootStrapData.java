package com.firstspringwebapp.FirstSpringWebApp.bootstrap;

import com.firstspringwebapp.FirstSpringWebApp.domain.Author;
import com.firstspringwebapp.FirstSpringWebApp.domain.Book;
import com.firstspringwebapp.FirstSpringWebApp.domain.Publisher;
import com.firstspringwebapp.FirstSpringWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.firstspringwebapp.FirstSpringWebApp.repositories.AuthorRepository;
import com.firstspringwebapp.FirstSpringWebApp.repositories.BookRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        //author eric upload

        Publisher publisher = new Publisher();

        publisher.setName("Simrah");
        publisher.setAddress("Hyderabad");
        publisher.setCity("Hyderabad");
        publisher.setState("Telangana");
        publisher.setZip("500059");

        publisherRepository.save(publisher);

        System.out.println("Add Publisher, Count " + publisherRepository.count());

        Author eric = new Author("Dave", "Evens");
        Book ddd = new Book("Domain Driven", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        System.out.println("Bootstrap application started running");
        System.out.println("Number of books " + bookRepository.count());
        // System.out.println("Number of authors" + authorRepository.count());

    }
}
