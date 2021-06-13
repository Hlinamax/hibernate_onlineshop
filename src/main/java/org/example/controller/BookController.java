package org.example.controller;

import org.example.entity.Book;
import org.example.repository.BookRepository;
import  org.example.repository.impl.BookRepositoryImpl;

import java.sql.SQLException;
import java.util.List;


public class BookController {
    private BookRepository bookRepository = new BookRepositoryImpl();

    public Book getBookById(Long id) throws SQLException {
        return bookRepository.getById(id);
    }

    public Book editBook(Book book) throws SQLException {
        return bookRepository.update(book);
    }

    public List<Book> getAllBooks() throws SQLException {
        return bookRepository.getAll();
    }

    public void saveBook(Book book) throws SQLException {
        bookRepository.add(book);
    }

    public void deleteBook(Long id) throws SQLException {
        bookRepository.remove(id);
    }

}
