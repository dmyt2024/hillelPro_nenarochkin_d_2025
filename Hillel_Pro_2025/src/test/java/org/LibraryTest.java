package org;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lesson_31_JUnitTest.Book;
import org.lesson_31_JUnitTest.Library;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    Library library;

    @BeforeEach

    public void setUp() {
        library = new Library();
    }

    @AfterEach
    public void cleanLibrary() {
        library.clearLibrary();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Чистий код", "Роберт Мартін");
        library.addBook(book);

        assertEquals(1, library.getBooks().size());
        assertTrue(library.getBooks().contains(book));
    }

    @Test
    public void testAddBookNullTrowException() {
        assertThrows(IllegalArgumentException.class, () -> library.addBook(null));
    }

    @Test
    public void testRemoveBook() {
        Book book = new Book("Чистий код", "Роберт Мартін");
        library.addBook(book);
        boolean removed = library.removeBook(book);

        assertTrue(removed);
        assertEquals(0, library.getBookCount());
    }

    @Test
    public void testRemoveBookNullTrowException() {
        assertThrows(IllegalArgumentException.class, () -> library.removeBook(null));
    }

    @Test
    public void testRemoveNotExistBookReturnFalse() {
        Book book = new Book("NotExisting", "Author");
        library.removeBook(book);
        boolean removed = library.removeBook(book);

        assertFalse(removed);
    }

    @Test
    public void testGetBooks() {
        Book book = new Book("Чистий код", "Роберт Мартін");
        library.addBook(book);
        List<Book> books = library.getBooks();

        assertEquals(1, books.size());
        assertTrue(books.contains(book));

    }

    @Test
    public void testUnmodifiableList() {
        Book book = new Book("Чистий код", "Роберт Мартін");
        library.addBook(book);
        List<Book> books = library.getBooks();

        assertThrows(UnsupportedOperationException.class, ()
                -> books.add(new Book("ChangedTitle", "ChangedAuthor")));
    }

    @Test
    public void testGetBookCount() {
        assertEquals(0, library.getBookCount());
    }
}
