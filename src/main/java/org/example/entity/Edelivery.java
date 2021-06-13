package org.example.entity;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@Table(name = "edelivery", schema = "onlineshop")
public class Edelivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "count_of_books")
    private String countOfBooks;
    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id")
    private Order orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountOfBooks() {
        return countOfBooks;
    }

    public void setCountOfBooks(String countOfBooks) {
        this.countOfBooks = countOfBooks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Order getOrder() {
        return orders;
    }

    public void setOrder(Order orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Edelivery{" +
                "id=" + id +
                ", countOfBooks='" + countOfBooks + '\'' +
                ", date='" + date + '\'' +
                ", customer=" + customer.getName() +
                ", book=" + book.getName() +
                ", orders=" + orders.getName() +
                '}';
    }
}