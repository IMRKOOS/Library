package manager;

import entities.*;

import java.util.Date;
import java.util.List;

public interface ManagerOfLibrary {
    void addAuthor(Author author);

    void addBook(Book book);
    void addUser(User user);
    void giveBook(User user, Book... books);
    void returnBook(User user, Book book);
    void addToHistory(HistoryEntry obj,User user,Book book);
     Author findAuthor (String name) throws LibraryException;
     List<HistoryEntry> getHistory(HistoryEntry obj);

}
