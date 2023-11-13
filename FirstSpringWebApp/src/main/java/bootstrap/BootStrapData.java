package bootstrap;

import domain.Author;
import domain.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import repositories.AuthorRepository;
import repositories.BookRepository;

@Component
public class BootStrapData implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //author eric upload
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
