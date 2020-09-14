package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher pub1 = new Publisher("O'Reilly publicher", "Some AdreeLIne", "St Pete", "Florid", "Zip1");
        publisherRepository.save(pub1);

        System.out.println("Total number of publishers is " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Domain driven dessing", "isbn1234");

        eric.getBooks().add(book1);
        book1.getAuthors().add(eric);

        book1.setPublisher(pub1);
        pub1.getBooks().add(book1);

        authorRepository.save(eric);
        bookRepository.save(book1);
        publisherRepository.save(pub1);

        Author rod = new Author("Rod", "Jhonson");
        Book book2 = new Book("J2EE Development", "isbn9876");

        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);

        book2.setPublisher(pub1);
        pub1.getBooks().add(book2);

        authorRepository.save(rod);
        bookRepository.save(book2);
        publisherRepository.save(pub1);

        System.out.println("Strated in BootStrap");
        System.out.println("Number Publisher of Books" + pub1.getBooks().size());



    }
}
