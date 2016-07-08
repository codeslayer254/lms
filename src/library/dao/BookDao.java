/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.dao;

import library.model.Book;
import java.sql.ResultSet;

public class BookDao extends BaseDao {

    TransactionHistoryDao transactionHistoryDao = new TransactionHistoryDao();

    public BookDao() {
        super();
    }

    public void save(Book book) throws Exception {
        StringBuilder query = new StringBuilder();

        book.setStatus("AVAILABLE");

        query = query.append("INSERT INTO BOOKS ")
                .append("(TITLE, CATEGORY, AUTHOR, ISBN, STATUS) ")
                .append("VALUES(")
                .append("'" + book.getTitle() + "',")
                .append("'" + book.getCategory() + "',")
                .append("'" + book.getAuthor() + "',")
                .append("'" + book.getIsbn() + "',")
                .append("'" + book.getStatus() + "'")
                .append(")");
        insert(query.toString());
    }

    public void delete(Book book) throws Exception {
        StringBuilder query = new StringBuilder();

        query = query.append("DELETE FROM `books` WHERE `BOOK_ID` = " + book.getId());

        insert(query.toString());
    }

    public void update(Book book) throws Exception {
        StringBuilder query = new StringBuilder();

        query = query.append(
                "UPDATE `books`"
                + "SET `TITLE` = '" + book.getTitle() + "' , `CATEGORY` = '" + book.getCategory()
                + "' , `AUTHOR` = '" + book.getAuthor() + "' , `ISBN` = '" + book.getIsbn()
                + "' , `STATUS` = '" + book.getStatus() + "' , `LIBRARIAN_ID` = '" + book.getLibarianID()
                + "' WHERE " + "`BOOK_ID` = '" + book.getId() + "'");

        insert(query.toString());
    }

    public void checkIn(Book book) throws Exception {
        StringBuilder query = new StringBuilder();

        transactionHistoryDao.rewriteHistory(
                transactionHistoryDao.findlibrarianHistory(book.getLibarianID(), "BORROWED").getId(),
                book.getStatus());

        book.setLibarianID(0);
        query = query.append(
                "UPDATE `books`"
                + "SET `TITLE` = '" + book.getTitle() + "' , `CATEGORY` = '" + book.getCategory()
                + "' , `AUTHOR` = '" + book.getAuthor() + "' , `ISBN` = '" + book.getIsbn()
                + "' , `STATUS` = '" + book.getStatus() + "' , `LIBRARIAN_ID` = '" + null
                + "' WHERE " + "`BOOK_ID` = '" + book.getId() + "'");

        insert(query.toString());
    }

    public void checkOut(Book book) throws Exception {
        StringBuilder query = new StringBuilder();

        transactionHistoryDao.writeHistory(book);

        query = query.append(
                "UPDATE `books`"
                + "SET `TITLE` = '" + book.getTitle() + "' , `CATEGORY` = '" + book.getCategory()
                + "' , `AUTHOR` = '" + book.getAuthor() + "' , `ISBN` = '" + book.getIsbn()
                + "' , `STATUS` = '" + book.getStatus() + "' , `LIBRARIAN_ID` = '" + book.getLibarianID()
                + "' WHERE " + "`BOOK_ID` = '" + book.getId() + "'");

        insert(query.toString());
    }

    public Book findBookByISBN(String isbn) throws Exception {
        StringBuilder query = new StringBuilder();
        Book book = null;

        query = query.append("SELECT * FROM BOOKS WHERE ISBN = '" + isbn + "'");
        ResultSet rs = select(query.toString());

        while (rs.next()) {
            book = new Book();
            book.setId(rs.getLong("BOOK_ID"));
            book.setTitle(rs.getString("TITLE"));
            book.setCategory(rs.getString("CATEGORY"));
            book.setAuthor(rs.getString("AUTHOR"));
            book.setIsbn(rs.getString("ISBN"));
            book.setStatus(rs.getString("STATUS"));

        }

        return book;
    }

    public Book findBook(String title) throws Exception {
        StringBuilder query = new StringBuilder();
        Book book = null;

        query = query.append("SELECT * FROM BOOKS WHERE TITLE = '" + title + "'");
        ResultSet rs = select(query.toString());

        while (rs.next()) {
            book = new Book();
            book.setId(rs.getLong("BOOK_ID"));
            book.setTitle(rs.getString("TITLE"));
            book.setCategory(rs.getString("CATEGORY"));
            book.setAuthor(rs.getString("AUTHOR"));
            book.setIsbn(rs.getString("ISBN"));
            book.setStatus(rs.getString("STATUS"));

        }

        return book;
    }

    public Book findBook(String title, String name) throws Exception {
        StringBuilder query = new StringBuilder();
        Book book = null;

        query = query.append("SELECT * FROM BOOKS WHERE TITLE = '" + title + "'");
        ResultSet rs = select(query.toString());

        while (rs.next()) {
            book = new Book();
            book.setId(rs.getLong("BOOK_ID"));
            book.setTitle(rs.getString("TITLE"));
            book.setCategory(rs.getString("CATEGORY"));
            book.setAuthor(rs.getString("AUTHOR"));
            book.setIsbn(rs.getString("ISBN"));
            book.setStatus(rs.getString("STATUS"));

        }

        return book;
    }

    
    public Book findBookByID(String bookId) throws Exception {
        StringBuilder query = new StringBuilder();
        Book book = null;

        query = query.append("SELECT * FROM BOOKS WHERE BOOK_ID = '" + bookId + "'");
        ResultSet rs = select(query.toString());

        while (rs.next()) {
            book = new Book();
            book.setId(rs.getLong("BOOK_ID"));
            book.setTitle(rs.getString("TITLE"));
            book.setCategory(rs.getString("CATEGORY"));
            book.setAuthor(rs.getString("AUTHOR"));
            book.setIsbn(rs.getString("ISBN"));
            book.setStatus(rs.getString("STATUS"));
        }

        return book;
    }
    
    public Book findBookByID(String bookId, boolean isBorrowed) throws Exception {
        StringBuilder query = new StringBuilder();
        Book book = null;

        query = query.append("SELECT * FROM BOOKS WHERE BOOK_ID = '" + bookId + "'");
        ResultSet rs = select(query.toString());

        while (rs.next()) {
            book = new Book();
            book.setId(rs.getLong("BOOK_ID"));
            book.setTitle(rs.getString("TITLE"));
            book.setCategory(rs.getString("CATEGORY"));
            book.setAuthor(rs.getString("AUTHOR"));
            book.setIsbn(rs.getString("ISBN"));
            book.setStatus(rs.getString("STATUS"));

            if (isBorrowed) {
                book.setLibarianID(Long.parseLong(rs.getString("LIBRARIAN_ID")));
            }

        }

        return book;
    }

}
