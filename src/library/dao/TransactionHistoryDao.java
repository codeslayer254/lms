/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.dao;

import java.sql.ResultSet;
import java.util.Date;
import library.model.Book;
import library.model.TransactionHistory;

/**
 *
 * @author meyor
 */
public class TransactionHistoryDao extends BaseDao {
    
     public TransactionHistoryDao() {
        super();
    }
    
     public void writeHistory(Book book) throws Exception {
        StringBuilder query = new StringBuilder();
    
        query = query.append("INSERT INTO TRANSACTION_HISTORY ")
                .append("(TITLE, AUTHOR, ISBN, STATUS, DATE_BORROWED, DATE_RETURNED, LIBRARIAN_ID) ")
                .append("VALUES(")
                .append("'" + book.getTitle() + "',")
                .append("'" + book.getAuthor() + "',")
                .append("'" + book.getIsbn() + "',")
                .append("'" + book.getStatus() + "',")
                .append("'" + new Date() + "',")
                .append("'PENDING',")
                .append("'" + book.getLibarianID()+ "'")
                .append(")");
        insert(query.toString());

    }
     
     public void rewriteHistory(long historyId, String bookStatus) throws Exception {
        StringBuilder query = new StringBuilder();
        
        query = query.append(
                "UPDATE `transaction_history`" 
                        + "SET `STATUS` = '" + bookStatus + "' , `DATE_RETURNED` = '" + new Date()
                        + "' WHERE " + "`TRANSACTION_ID` = '" + historyId + "'");

        insert(query.toString());

    }
     
      public TransactionHistory findlibrarianHistory(long librarianId, String bookStatus) throws Exception {
        StringBuilder query = new StringBuilder();
        TransactionHistory history = null;

        query = query.append("SELECT * FROM TRANSACTION_HISTORY WHERE LIBRARIAN_ID = '" + librarianId + "'"
                                       + " AND " + "STATUS = '" + bookStatus + "'");
        ResultSet rs = select(query.toString());
                 
        while (rs.next()) {
            history = new TransactionHistory();
            history.setId(rs.getLong("TRANSACTION_ID"));
            history.setTitle(rs.getString("TITLE"));
            history.setAuthor(rs.getString("AUTHOR"));
            history.setIsbn(rs.getString("ISBN"));
            history.setStatus(rs.getString("STATUS"));
            history.setLibrarian(Long.parseLong(rs.getString("LIBRARIAN_ID")));

        }

        return history;
    }
     
    
}
