package com.parcial.uno.parcial_uno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.parcial.uno.parcial_uno.dtos.BookDTO;
import com.parcial.uno.parcial_uno.model.Book;
import com.parcial.uno.parcial_uno.repository.BookRepository;

@Service
public class BookService implements IBookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public BookDTO create(Book book) {
        Book saved = bookRepository.save(book);
        return toDTO(saved);
    }

    @Override
    public BookDTO findById(String id) {
        return bookRepository.findById(id).map(this::toDTO).orElse(new BookDTO());
    }

    @Override
    public BookDTO findByISBN(String isbn) {
        return bookRepository.findByIsbn(isbn).map(this::toDTO).orElse(new BookDTO());
    }

    @Override
    public BookDTO update(String id, BookDTO dto) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setIsbn(dto.getIsbn());
            book.setName(dto.getName());
            book.setAmount(dto.getAmount());
            book.setAvailable(dto.getAvailable());
            return toDTO(bookRepository.save(book));
        }
        return new BookDTO();
    }

    @Override
    public String delete(String id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return "El libro fue eliminado de forma correcta";
        }
        return "El libro no fue encontrado";
    }

    private BookDTO toDTO(Book book) {
        return new BookDTO(book.getBookId(), book.getIsbn(), book.getName(), book.getAmount(), book.getAvailable());
    }
}
