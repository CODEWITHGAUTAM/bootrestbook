package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;
@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // private static List<Book> list=new ArrayList<>();
    // static{
    //     list.add(new Book(12,"Python","Ankita"));
    //     list.add(new Book(14,"C++","Gautam"));
    //     list.add(new Book(16,"Javascript","Arti"));

    // }

    //get all books

    public List<Book> getAllBooks()
    {
        List<Book> result=(List<Book>)this.bookRepository.findAll();
        return result;
    }
    //get single book by id
    public Book getBookById(int id)
    {
        Book book=null;
        try{
            book=this.bookRepository.findById(id);
        }
        catch(Exception e)
        {
             e.getMessage();
        }
        return book;
    }
    //Adding the book
    public Book addBook(Book b)
    {
        Book result=this.bookRepository.save(b);
        return result;
    }
    //Deleting the book

    public void deleteBook(int bId)
    {
       this.bookRepository.deleteById(bId);
    }

    //Updating the book

    public void updateBook(Book book,int bookId)
    {
        book.setId(bookId);
       this.bookRepository.save(book);
    }


    
}
