package org.lesson_31_JUnitTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {

    List<Book> books = new ArrayList<Book>();


    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.add(book);

    }

    public boolean removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        return books.remove(book);
    }

    public List<Book> getBooks() {

        return Collections.unmodifiableList(books);
    }

    public int getBookCount() {

        return books.size();
    }

    public void clearLibrary() {
        books.clear();

    }
}
