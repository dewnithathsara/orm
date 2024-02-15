package org.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private LocalDate publishdate;
    private double price;
    @ManyToOne
    @JoinColumn(name = "authors_id")
    private Author author;

    public Book(){}

    public Book(Long id, String title, LocalDate date, double price, Author author) {
        Id = id;
        this.title = title;
        this.publishdate = date;
        this.price = price;
        this.author = author;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return publishdate;
    }

    public void setDate(LocalDate  date) {
        this.publishdate = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", price='" + price + '\'' +
                ", title=" + title +
                ", author=" + author +
                ", publishdate=" + publishdate+
        '}';
    }
}
