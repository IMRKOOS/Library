package manager;

import entities.Author;
import entities.Book;
import entities.User;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
       User mark = new User("Mark","Nechyporenko", "Markovych",new Date(1997,02,23));
        System.out.println(mark);
        Librarian madamJuhariya = Librarian.getInstance();
        madamJuhariya.addAuthor(new Author("Ivan","Prokopiev", "Andreevych", "Anjey Sapckovskiy"));
        madamJuhariya.addAuthor(new Author("Andrey","Giuriyanov","Vitaliyevich", "Philip Kirkorov"));
        Book witcher = new Book("Witcher", "Anjey Sapckovskiy", 1987,465);
        Book lotr = new Book("Lord of the Rings","Tolkien", 1978,465);
        Book harryPotter = new Book("Harry Potter","Joan Rouling",1995,687);
        madamJuhariya.addBook(harryPotter);
        Author author = new Author("Ashla","Kinvara","Lyamlya","Joan Rouling");
        madamJuhariya.addAuthor(author);
        madamJuhariya.addBook(witcher);
        madamJuhariya.addUser(mark);
        System.out.println(madamJuhariya.getCatalogAuthors());
        User alina =new User("Alina","Nechyporenko","Maratovna",new Date(1998,4,3));
        Book azbucka = new Book("Azbucka","Obichniy", 0,32);
        madamJuhariya.giveBook(mark,azbucka,lotr);
        madamJuhariya.addAuthor(new Author("petro" ,"petrovich","ivanov","Tolkien"));
        madamJuhariya.addBook(lotr);
        madamJuhariya.giveBook(mark,lotr);
        madamJuhariya.giveBook(mark,harryPotter);
     System.out.println(mark.getDebt());
     System.out.println(madamJuhariya.getHistory());
    }
}
