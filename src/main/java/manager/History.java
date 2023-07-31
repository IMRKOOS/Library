package manager;

import entities.Book;
import entities.HistoryEntry;
import entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public final class History {
    private HistoryEntry type;
       private User user;
    private Book book;




        public History(User user,Book book,HistoryEntry type){
        this.book = book;
        this.user = user;
        this.type = type;
        }

    public HistoryEntry getType() {
        return type;
    }

    @Override
    public String toString() {
        return type.name() + ". " + user.getSurName() + " "+ user.getName()+
                "( " + book.getName() +
                " )";
    }
}

