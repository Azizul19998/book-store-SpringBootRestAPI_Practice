package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {



    private List<Book> bookList;
    private int id;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookController(){
        this.bookList = new ArrayList<Book>();
        this.id = 1;

    }

    // post request /create-book
    // pass book as request body
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        // Your code goes here.
        book.setId(this.id);
        this.id = this.id +1;
        bookList.add(book);

        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // get request /get-book-by-id/{id}
    // pass id as path variable
    // getBookById()
    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity getBookById ( @PathVariable("id") int id) {
                for(Book b : bookList) {
                    if(b.getId()== id)
                        return new ResponseEntity<>(b, HttpStatus.OK);
                }
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    // delete request /delete-book-by-id/{id}
    // pass id as path variable
    // deleteBookById()
        @DeleteMapping("/delete-book-by-id/{id}")
        public ResponseEntity deleteBookById(@PathVariable Integer id)
        {
            for(Book b : bookList) {
                if(b.getId()== id) {
                    bookList.remove(b);
                    return new ResponseEntity<>(" Delete by Id Success", HttpStatus.OK);
                }

            }
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    // get request /get-all-books
    // getAllBooks()
    @GetMapping("/get-all-books")
    public ResponseEntity getAllBooks () {
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    // delete request /delete-all-books
    // deleteAllBooks()
    @DeleteMapping("/delete-all-books")
    public ResponseEntity deleteAllBooks () {
        bookList = new ArrayList<>();
        this.id=1;
        return  new ResponseEntity("deletion successfull", HttpStatus.OK);
    }

    // get request /get-books-by-author
    // pass author name as request param
    // getBooksByAuthor()
    @GetMapping("/get-books-by-author")
    public ResponseEntity getBooksByAuthor(@RequestParam("author") String author) {
        for(Book b : bookList) {
            if(b.getAuthor().equals(author)) {
                return new ResponseEntity<>(b, HttpStatus.OK);
            }

        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    // get request /get-books-by-genre
    // pass genre name as request param
    // getBooksByGenre()
    @GetMapping("/get-books-by-genre")
    public ResponseEntity getBooksByGenre ( @RequestParam("genre") String genre) {
        for(Book b : bookList) {
            if(b.getGenre().equals(genre)) {
                return new ResponseEntity<>(b, HttpStatus.OK);
            }

        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
