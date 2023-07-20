package entities;

import java.util.Objects;

public class Author {
    private String name;
    private String surName;
    private String secondName;
    private String nikName;

    public Author(String name, String surName, String secondName, String nikName) {
        this.name = name;
        this.surName = surName;
        this.secondName = secondName;
        this.nikName = nikName;
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

    public String getNikName() {
        return nikName;
    }

    public void setNikName(String nikName) {
        this.nikName = nikName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return Objects.equals(name, author.name) && Objects.equals(surName, author.surName) && Objects.equals(secondName, author.secondName) && Objects.equals(nikName, author.nikName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, secondName, nikName);
    }

    @Override
    public String toString() {
        return "entities.Author{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", nikName='" + nikName + '\'' +
                '}';
    }
}
