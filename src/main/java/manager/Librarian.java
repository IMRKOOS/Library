package manager;
import entities.Author;
import entities.Book;
import entities.User;

import java.util.*;

public final class Librarian implements ManagerOfLibrary{
    private static final List<Book> catalogBooks = new ArrayList<>();
    private static final List<Author> catalogAuthors = new ArrayList<>();
    private static final List<User> catalogUsers = new ArrayList<>();
    private static final List<History> historyList = new ArrayList<>();

    @Override
    public void addAuthor(Author author) {
        catalogAuthors.add(author);
    }

    @Override
    public void addBook(Book book) {
        catalogBooks.add(book);
    }

    @Override
    public void addUser(User user) {
catalogUsers.add(user);
    }

    @Override
    public void giveBook(User user,Book... books) {
        user.setDebt(Arrays.asList(books));
       List<Book> giveBooks = Arrays.asList(books);
        for (Book each:
             giveBooks) {
            addToHistory(user,each);
        }
    }

    @Override
    public void addToHistory(User user, Book book) {
        History history = new History(user,book);
        historyList.add(history);
    }

    @Override
    public Author findAuthor(String nikName) {
        for (Author author:
             catalogAuthors) {
           if (author.getNikName().equals(nikName)){
               return author;
           }
        }
        return null;
    }

    public List<Author> getCatalogAuthors() {
        return catalogAuthors;
    }
    public List<History> getHistoryList(){
        return historyList;
    }
}



