Annotations
 @Entity
to tell that This java class represents a entity in database;
@Id
 to identify primary key of the entity
@ManyToOne
Many books owned by One Author
@OneToMany
One Author owns many books
@JoinColumn

@GeneratedValue
when new data is input auto generated the value 

   1)    String bookHql = "from Book b where b.publishdate>:publishYear";
         Query query = session.createQuery(bookHql);
         query.setParameter("publishYear", LocalDate.of(2010,12,31));
         List<Book> result = query.list();
                  for(Book book:result){
                      System.out.println(book.getId());
                      System.out.println(book.getPrice());
                      System.out.println(book.getTitle());
                      //System.out.println(book.getDate());
                      System.out.println(book.getAuthor());
                      System.out.println(book.getDate());
                  }
                 
   2) Long authorId= 10L;
      String updateQuery = "UPDATE Book b SET b.price = b.price * 1.1 where b.author.id= :athorid";
      Query update=session.createQuery(updateQuery);
      update.setParameter("athorid", authorId);
      int rst = update.executeUpdate();
      System.out.println(rst);
3) 
4) String avereage = "select avg(b.price) from Book b";
   Query query=session.createQuery(avereage);
   Double avg= (Double) query.uniqueResult();
   System.out.println(avg);
   
6)   String hql="Select a, COUNT (b) from Author a LEFT JOIN a.book b GROUP BY a";
     Query query= session.createQuery(hql);
     List<Object[]> rst=query.list();
     for(Object[] objects:rst){
     Author author=(Author) objects[0];
     Long bookCount=(Long) objects[1];
     System.out.println("author"+author.getName());
     System.out.println("bookCount"+bookCount);
     } 
7)  String Address= "America"
    String hql="select a.name from Author a where a.country=:address";
    Query query=session.createQuery(hql);
    query.setParameter("address",Address)
    int rst=query.executeUpdate();

8)
    Author  has a collection that holds multiple instance of Book  So we can say Author and Book has bidirectional  one to Many relationship
   @JoinColumn annotation to specify the mapping of a foreign key column in a relationship between 
   Book entity and Author entity. The @JoinColumn annotation is applied on the owning side(Book) of the association to define
   the foreign key column name and other attributes which are related to the join column.

9) String hql = "SELECT AVG (b.id) FROM Book b";
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
