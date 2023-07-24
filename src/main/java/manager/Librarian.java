package manager;
import entities.Author;
import entities.Book;
import entities.Catalog;
import entities.User;

import java.io.IOException;
import java.util.*;

public final class Librarian implements ManagerOfLibrary{
    private static Librarian instance;
    private static final Catalog<Book> catalogBooks = new Catalog<>();
    private static final Catalog<Author> catalogAuthors = new Catalog<>();
    private static final Catalog<User> catalogUsers = new Catalog<>();
    private static final List<History> historyList = new ArrayList<>();
    private Librarian(){}
    public static Librarian getInstance(){
        if (instance == null){
            instance = new Librarian();
        }
        return instance;
    }

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
        List<Book> giveBooks = Arrays.asList(books);
        try{
            test(user);
            test(books);
            user.setDebt(giveBooks);
            for (Book book:
                    giveBooks){
                catalogBooks.getCatalog().remove(book);
            }
            for (Book each:
                    giveBooks) {
                addToHistory(user,each);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    private void test (User user)throws IOException{
        catalogUsers.hasA(user);
        }
    private void test (Book...books)throws IOException{
        List<Book> books1 = Arrays.asList(books);

            for (Book book:
                 books1) {
                    catalogBooks.hasA(book);
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
             catalogAuthors.getCatalog()) {
           if (author.getNikName().equals(nikName)){
               return author;
           }
        }
        return null;
    }


    public List<Author> getCatalogAuthors() {
        return catalogAuthors.getCatalog();
    }
    public List<History> getHistoryList(){
        return historyList;
    }
}



