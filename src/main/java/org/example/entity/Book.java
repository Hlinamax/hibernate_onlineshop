package org.example.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "book", schema = "onlineshop")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Column(name = "year", nullable = true, length = 45)
    private String year;
    @Column(name = "price", nullable = true, length = 45)
    private String price;
    @Column(name = "category", nullable = true, length = 45)
    private String category;
    @Column(name = "count", nullable = true, length = 45)
    private String count;
    @Column(name = "descriprion", nullable = true, length = 45)
    private String descriprion;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(targetEntity = Edelivery.class, mappedBy = "book")
    private List<Edelivery> edelivery;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    public List<Edelivery> getEdelivery() {
        return edelivery;
    }

    public void setEdelivery(List<Edelivery> edelivery) {
        this.edelivery = edelivery;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", price='" + price + '\'' +
                ", category='" + category + '\'' +
                ", count='" + count + '\'' +
                ", descriprion='" + descriprion + '\'' +
                '}';
    }
}

