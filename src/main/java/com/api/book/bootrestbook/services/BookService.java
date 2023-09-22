package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;
@Component
public class BookService {
    private static List<Book> list=new ArrayList<>();
    static{
        list.add(new Book(12,"Python","Ankita"));
        list.add(new Book(14,"C++","Gautam"));
        list.add(new Book(16,"Javascript","Arti"));

    }

    //get all books

    public List<Book> getAllBooks()
    {
        return list;
    }
    //get single book by id
    public Book getBookById(int id)
    {
        Book book=null;
        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        return book;
    }
    //Adding the book
    public Book addBook(Book b)
    {
        list.add(b);
        return b;
    }
    //Deleting the book

    public void deleteBook(int bId)
    {
       Iterator<Book> i=list.iterator();
       while(i.hasNext())
       {
        Book b=i.next();
        if(b.getId()==bId)
        {
            list.remove(b);
        }
       }
    }

    //Updating the book

    public void updateBook(Book book,int bookId)
    {
        
        Iterator<Book> i=list.iterator();
       while(i.hasNext())
       {
        Book b=i.next();
        if(b.getId()==bookId)
        {
            list.remove(b);
            list.add(book);
        }
       }
    }


    
}
