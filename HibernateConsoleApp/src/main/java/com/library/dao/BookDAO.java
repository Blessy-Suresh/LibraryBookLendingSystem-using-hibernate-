package com.library.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.Book;
import com.kce.util.HibernateUtil;

public class BookDAO {

    public Book findBook(String bookID) {

        Session session =
            HibernateUtil.getSessionFactory().openSession();

        Book book = session.get(Book.class, bookID);

        session.close();

        return book;
    }

    public boolean updateAvailableCopies(String bookID, int count) {

        Session session =
            HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Book book = session.get(Book.class, bookID);

            if (book == null) {
                return false;
            }

            book.setAvailableCopies(count);

            session.update(book);

            tx.commit();
            session.close();

            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            session.close();
            return false;
        }
    }
}





//package com.library.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.library.bean.Book;
//import com.library.util.DBUtil;
//
//public class BookDAO {
//
//    public Book findBook(String bookID) {
//
//        Connection connection = DBUtil.getDBConnection();
//        String query = "SELECT * FROM BOOK_TBL WHERE BOOK_ID=?";
//
//        Book book = null;
//
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setString(1, bookID);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                book = new Book();
//                book.setBookID(rs.getString(1));
//                book.setTitle(rs.getString(2));
//                book.setAuthor(rs.getString(3));
//                book.setTotalCopies(rs.getInt(4));
//                book.setAvailableCopies(rs.getInt(5));
//            }
//
//            return book;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public boolean updateAvailableCopies(String bookID, int count) {
//
//        Connection connection = DBUtil.getDBConnection();
//        String query =
//                "UPDATE BOOK_TBL SET AVAILABLE_COPIES=? WHERE BOOK_ID=?";
//
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, count);
//            ps.setString(2, bookID);
//
//            int result = ps.executeUpdate();
//
//            if (result > 0) {
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//}
