package com.istad.booksresourceapi.service;

import com.istad.booksresourceapi.model.Book;
import com.istad.booksresourceapi.model.request.BookRequest;

import java.util.List;

public interface BookService {
    public List<Book> findAllBook();
    public Book findBookByID(int id);
    public int deleteBookByID(int id);
    public int insertBook(BookRequest book);
    public int updateBook(BookRequest book,int id);
}
