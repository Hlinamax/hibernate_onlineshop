package org.example.controller;

import org.example.entity.Order;
import org.example.repository.OrderRepository;
import org.example.repository.impl.OrderRepositoryImpl;

import java.sql.SQLException;
import java.util.List;


public class OrderController {
    private OrderRepository orderRepository = new OrderRepositoryImpl();

    public Order getOrderById(Long id) throws SQLException{
        return orderRepository.getById(id);
    }
    public Order editOrder(Order order) throws  SQLException{
        return orderRepository.update(order);
    }
    public List<Order> getAllOrders() throws SQLException {
        return orderRepository.getAll();
    }

    public void saveOrder(Order order) throws SQLException {
        orderRepository.add(order);
    }

    public void deleteOrder(Long id) throws SQLException {
        orderRepository.remove(id);
    }

}