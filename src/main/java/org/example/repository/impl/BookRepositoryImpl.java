package org.example.repository.impl;

import org.example.entity.Book;
import org.example.repository.BookRepository;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {
    private Session session;
    private Transaction transaction;

    @Override
    public void add(Book book) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(book);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Book> getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "FROM Book";
        List<Book> books = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return books;
    }

    @Override
    public Book getById(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Book book = session.get(Book.class, id);
        transaction.commit();
        session.close();
        return book;
    }

    @Override
    public Book update(Book book) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(book);
        transaction.commit();
        session.close();
        return book;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Book book = session.get(Book.class, id);
        session.remove(book);
        transaction.commit();
        session.close();
    }
}