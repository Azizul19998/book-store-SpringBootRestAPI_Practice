# book-store-SpringBootRestAPI_Practice



Book Store

You own a bookstore and you want to make a simple spring boot application to perform basic CRUD operations to maintain your book records.
Requirements of the application:
Make an MVC architecture, with Book as your only model class, which will have id, name, author and genre as properties. Then make a controller class with appropriate annotations. Since you want to keep it simple, you don’t need to use any database. You can use a List of Books in the controller layer itself to store the records.

You need to implement the logic for following functionalities:

Save a book: /books/create-book - Return created book object as response
Get book object by Id: /books/get-book-by-id/{id} - Return book object as response
Get all books: /books/get-all-books - Return book object as response
Get books by author: /books/get-books-by-author?author=author+name
Get books by genre: /books/get-books-by-genre?genre=genre+name
Delete book by id: /books/delete-book-by-id/{id}
Delete all books: /books/delete-all-books\

Book Class - id, name, author, genre, constructors and getters-setters

Note:

/create-book should be a post request taking name, author and genre as part of the request body and id(should always be a natural number) should be generated every time we create a new entry
For delete requests you don't have to return body of the deleted object, a success message is fine
Use ResponseEntity object to return response in the controller
Make sure you test all APIs in postman before you submit.
