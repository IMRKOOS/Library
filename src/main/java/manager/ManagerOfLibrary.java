package manager;

import entities.Author;
import entities.Book;
import entities.User;

import java.util.Date;

public interface ManagerOfLibrary {
    void addAuthor(Author author);

    void addBook(Book book);
    void addUser(User user);
    void giveBook(User user, Book... books);

    void addToHistory(User user, Book book);
     Author findAuthor (String name);

}
