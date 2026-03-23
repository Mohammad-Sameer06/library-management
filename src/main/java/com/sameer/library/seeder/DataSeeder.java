package com.sameer.library.seeder;

import com.sameer.library.entity.Book;
import com.sameer.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // This tells Spring Boot: "Hey, I am a special tool, turn me on when the app starts!"
public class DataSeeder implements CommandLineRunner {

    private final BookRepository bookRepository;

    // The truck needs to know where the Librarian is to hand over the books
    public DataSeeder(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Only drop off books if the library is completely empty
        if (bookRepository.count() == 0) {

            Book book1 = new Book();
            book1.setTitle("The Art of Solo Trekking");
            book1.setIsbn("TRK-101");
            book1.setIssued(false);

            Book book2 = new Book();
            book2.setTitle("Lofi Beats & Chill: A History");
            book2.setIsbn("LOFI-202");
            book2.setIssued(false);

            Book book3 = new Book();
            book3.setTitle("Supermarket Simulator Guide");
            book3.setIsbn("SIM-303");
            book3.setIssued(false);

            // Hand them to the Librarian to save in the database
            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);

            System.out.println("🚚 Beep Beep! The Delivery Truck just dropped off 3 books!");
        }
    }
}