package com.sameer.library.controller;

import com.sameer.library.entity.Book;
import com.sameer.library.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibraryController {

    private final BookRepository bookRepository;

    public LibraryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/home")
    public String viewHomePage(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "index";
    }

    @GetMapping("/add-book")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookRepository.save(book);
        return "redirect:/home";
    }

    // --- NEW RULES FOR BORROWING AND RETURNING ---

    @PostMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Long id) {
        // Find the book by its ID
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setIssued(true); // Change status to Borrowed
            bookRepository.save(book); // Save the change
        }
        return "redirect:/home"; // Go back to the main page
    }

    @PostMapping("/return/{id}")
    public String returnBook(@PathVariable Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setIssued(false); // Change status back to Available
            bookRepository.save(book);
        }
        return "redirect:/home";
    }
}