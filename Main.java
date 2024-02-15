package org.example;

import jdk.swing.interop.SwingInterOpUtils;
import org.example.config.FactoryConfiguration;
import org.example.entity.Author;
import org.example.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        String hql = "SELECT AVG (b.id) FROM Book b";
        Query query = session.createQuery(hql);

       Double avg = (Double) query.uniqueResult();
        System.out.println("Average Number of Books: " + avg);

        String Ahql="Select a, COUNT (b) from Author a LEFT JOIN a.book b GROUP BY a HAVING COUNT(b)>:average";
        Query qry= session.createQuery(Ahql);
        qry.setParameter("average",avg);
        List<Author> rst=qry.list();
        for(Author author:rst){

            System.out.println("author"+author.getName());

            System.out.println(author.getBook().size());

        }
        transaction.commit();
        session.close();

    }
}