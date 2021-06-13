package org.example.repository.impl;

import org.example.entity.Edelivery;
import org.example.repository.EdeliveryRepository;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class EdeliveryRepositoryImpl implements EdeliveryRepository {
    private Session session;
    private Transaction transaction;

    @Override
    public void add(Edelivery edelivery) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.save(edelivery);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Edelivery> getAll() throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        String hql = "FROM Edelivery";
        List<Edelivery> edeliverys = session.createQuery(hql).list();
        transaction.commit();
        session.close();
        return edeliverys;
    }

    @Override
    public Edelivery getById(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Edelivery edelivery = session.get(Edelivery.class, id);
        transaction.commit();
        session.close();
        return edelivery;
    }

    @Override
    public Edelivery update(Edelivery edelivery) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(edelivery);
        transaction.commit();
        session.close();
        return edelivery;
    }

    @Override
    public void remove(Long id) throws SQLException {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        Edelivery edelivery = session.get(Edelivery.class, id);
        session.remove(edelivery);
        transaction.commit();
        session.close();
    }
}