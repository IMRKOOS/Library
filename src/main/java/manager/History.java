package manager;

import entities.Book;
import entities.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public final class History {
       private User user;
    private Book book;




        public History(User user,Book book){
        this.book = book;
        this.user = user;
        }

    @Override
    public String toString() {
        return                 "user:" + user.getSurName() + " "+ user.getName()+
                ", book=" + book.getName() +
                '.';
    }
}

