package entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private String surName;
    private String secondName;
    private Date birth;
    private List<Book> debt;

    public User(String name, String surName, String secondName, Date birth) {
        this.name = name;
        this.surName = surName;
        this.secondName = secondName;
        this.birth = birth;
    }

    public List<Book> getDebt() {
        return debt;
    }

    public void setDebt(List<Book> debt) {
        this.debt = debt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(name, user.name) && Objects.equals(surName, user.surName) && Objects.equals(secondName, user.secondName) && Objects.equals(birth, user.birth) && Objects.equals(debt, user.debt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, secondName, birth, debt);
    }

    @Override
    public String toString() {
        return                 "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", birth=" + birth.getDate() +"." + birth.getMonth() + "." + birth.getYear() +
                ", debt=" + debt +
                '}';
    }
}
