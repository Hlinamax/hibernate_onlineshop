package org.example.repository.impl;

import org.example.entity.Order;
import org.example.repository.OrderRepository;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;


public class OrderRepositoryImpl implements OrderRepository {
    private Session session;
    private Transaction transaction;

    @Override
    public void add(Order order) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Order> getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "FROM Order";
        List<Order> orders = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return orders;
    }

    @Override
    public Order getById(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Order order = session.get(Order.class, id);
        transaction.commit();
        session.close();
        return order;
    }

    @Override
    public Order update(Order order) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(order);
        transaction.commit();
        session.close();
        return order;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Order order = session.get(Order.class, id);
        session.remove(order);
        transaction.commit();
        session.close();
    }
}