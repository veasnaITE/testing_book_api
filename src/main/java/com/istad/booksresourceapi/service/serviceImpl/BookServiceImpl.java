package com.istad.booksresourceapi.service.serviceImpl;
import com.istad.booksresourceapi.model.Book;
import com.istad.booksresourceapi.model.request.BookRequest;
import com.istad.booksresourceapi.repository.BookRepository;
import com.istad.booksresourceapi.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    BookServiceImpl(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    @Override
    public List<Book> findAllBook() {
        return bookRepository.findAllBook();
    }
    @Override
    public Book findBookByID(int id) {
        return bookRepository.findBookByID(id);
    }
    @Override
    public int deleteBookByID(int id) {
        return bookRepository.deleteBookByID(id);
    }
    @Override
    public int insertBook(BookRequest book) {
        return bookRepository.insertBook(book);
    }
    @Override
    public int updateBook(BookRequest book,int id) {
        return bookRepository.updateBook(book,id);
    }
}
