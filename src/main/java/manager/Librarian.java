package manager;
import entities.*;

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
            for (Book authorName:
            giveBooks){
                findAuthor(authorName.getAuthor());
            }
            for (Book book:
                    giveBooks){
                catalogBooks.getCatalog().remove(book);
            }
            for (Book debt:
                 giveBooks) {
                user.getDebt().add(debt);
            }
            for (Book each:
                    giveBooks) {
                addToHistory(HistoryEntry.TAKE,user, each);
            }
        }catch (LibraryException e){
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(User user, Book book){
        user.getDebt().remove(book);
        catalogBooks.getCatalog().add(book);
        addToHistory(HistoryEntry.RETURN,user,book);
    }
    private void test (User user)throws LibraryException {
        catalogUsers.hasA(user);
        }
    private void test (Book...books)throws LibraryException{
        List<Book> books1 = Arrays.asList(books);

            for (Book book:
                 books1) {
                    catalogBooks.hasA(book);
                }
            }



    @Override
    public void addToHistory(HistoryEntry obj, User user, Book book) {
        History history = new History(user,book, obj);
        historyList.add(history);
    }

    @Override
    public Author findAuthor(String nikName) throws LibraryException{
        for (Author author:
             catalogAuthors.getCatalog()) {
           if (author.getNikName().equals(nikName)){
               return author;
           }
        }
        throw new LibraryException("Catalog has not this author - "+nikName );
    }


    public List<Author> getCatalogAuthors() {
        return catalogAuthors.getCatalog();
    }
    public List<History> getHistory(){
        return historyList;
    }

    @Override
    public List<HistoryEntry> getHistory(HistoryEntry obj) {
        List<HistoryEntry> notes = new ArrayList<>();
        for (History each:
             historyList) {
            if (each.getType() == obj){notes.add(each.getType());}
        }
        return notes;
    }
}



