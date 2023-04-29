package com.istad.booksresourceapi.repository;

import com.istad.booksresourceapi.model.Book;
import com.istad.booksresourceapi.model.request.BookRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BookRepository {
    @Results({
            @Result(property = "authorID" ,column = "author_id"),
            @Result(property = "isPublic", column = "is_public")
    })
@Select("SELECT * FROM book_tb")
    public List<Book>findAllBook();
    @Results({
            @Result(property = "authorID" ,column = "author_id"),
            @Result(property = "isPublic", column = "is_public")
    })
@Select("SELECT * FROM book_tb where id = #{id}")
    public Book findBookByID(int id);
@Delete("Delete from book_tb where id=#{id}")
    public int deleteBookByID(int id);
@Insert("insert into book_tb(title, author_id, genre, is_public)\n" +
        "values (#{book.title},#{book.author_id},#{book.genre},#{book.is_public});")
    public int insertBook(BookRequest book);
@Update("Update book_tb set title=#{bookRequest.title},author_id=#{bookRequest.author_id},genre=#{bookRequest.genre},is_public=#{bookRequest.is_public}\n" +
        "where id=#{id};")
    public int updateBook(BookRequest bookRequest,int id);

}
