package com.istad.booksresourceapi.controller;

import com.istad.booksresourceapi.model.Book;
import com.istad.booksresourceapi.model.request.BookRequest;
import com.istad.booksresourceapi.service.BookService;
import com.istad.booksresourceapi.utils.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/book")
public class BookRestController {
private final BookService bookService;
BookRestController(BookService bookService){
    this.bookService=bookService;
}
@GetMapping("/all")
public Response<List<Book>> getAllBooks(){
try{
List<Book> books = bookService.findAllBook();
return Response.<List<Book>>ok().setPayload(books).setMessage("Success to Retrived data");
}catch (Exception e){
    return Response.<List<Book>>exception().setMessage("Fail to retrived date ");
}
}
@GetMapping("/{id}")
public Response<Book>getOneBook(@PathVariable int id){
try{
 Book response = bookService.findBookByID(id);
 if(response != null){
  return Response.<Book>ok().setPayload(response).setSuccess(true).setMessage("Book id "+id+"Found");
 }else {
     return Response.<Book>notFound().setMessage("Cann't found Books with id "+id).setSuccess(false);
 }
}catch (Exception e){
    return Response.<Book>exception().setMessage("Cann't find book By id "+id);
}
}
@PostMapping("/new-book")
 public Response<Book> addNewBook(@RequestBody BookRequest book){
int BookID = bookService.insertBook(book);
try{
   if(BookID> 0) {
       Book book1 =new Book().setTitle(book.getTitle()).setAuthorID(book.getAuthorID()).setGenre(book.getGenre()).setIsPublic(book.getIsPublic());
       return Response.<Book>createSuccess().setPayload(book1).setMessage("Post new Book successfully").setSuccess(true);
   }else {
       return Response.<Book>badRequest().setMessage("Bad Request to Posting new books").setSuccess(false);
   }
}catch (Exception e){
    return Response.<Book>exception().setMessage("Cann't Post New Books");
}
}
@PutMapping("/{id}")
    public Response<Book>updateBooksDate(@PathVariable int id, @RequestBody BookRequest bookRequest)
{
int BookID= bookService.updateBook(bookRequest, id);
    System.out.println(bookRequest);
try{
 if(BookID>0){
 Book book = new Book().setId(id).setTitle(bookRequest.getTitle()).setAuthorID(bookRequest.getAuthorID()).setIsPublic(bookRequest.getIsPublic());
 return Response.<Book>updateSuccess().setPayload(book).setMessage("Update Book data SuccessFully").setSuccess(true);
 }else {
     return Response.<Book>notFound().setMessage("Cann't update this Book Date").setSuccess(false);
 }
}catch (Exception e){
    return Response.<Book>exception().setMessage("Fail to update Books Data");
}
}
@DeleteMapping("/{id}")
    public Response<?> deteleBookByID(@PathVariable int id){
    int BookID= bookService.deleteBookByID(id);
    try{
      if(BookID>0){
          return Response.<Object>deleteSuccess().setMessage("The Book has been Delete Successfully").setSuccess(true);
      }else {
          return Response.<Object>notFound().setMessage("The Book with this id "+id+"doesn't exist ");
      }
    }catch (Exception e){
        return Response.< Object >exception().setMessage("Fail to Delete Book Data");
    }
}



}
