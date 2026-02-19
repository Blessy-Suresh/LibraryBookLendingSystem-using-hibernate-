package com.library.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.library.bean.Issue;
import com.kce.util.HibernateUtil;

import java.util.Date;

public class IssueDAO {

    public boolean recordIssue(Issue issue) {

        Session session =
            HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            session.save(issue);

            tx.commit();
            session.close();

            return true;

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            session.close();
            return false;
        }
    }

    public boolean closeIssue(int issueID) {

        Session session =
            HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();

            Issue issue = session.get(Issue.class, issueID);

            if (issue == null) {
                return false;
            }

            issue.setReturnDate(new Date());

            session.update(issue);

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
//import java.sql.Date;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.sql.SQLException;
//
//import com.library.bean.Issue;
//import com.library.util.DBUtil;
//
//public class IssueDAO {
//
//    public int generateIssueID() {
//
//        int issueId = 0;
//        Connection connection = DBUtil.getDBConnection();
//        String query = "SELECT NVL(MAX(ISSUE_ID),30000)+1 FROM ISSUE_TBL";
//
//        try {
//            Statement st = connection.createStatement();
//            ResultSet rs = st.executeQuery(query);
//
//            if (rs.next()) {
//                issueId = rs.getInt(1);
//            }
//            return issueId;
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return 0;
//        }
//    }
//
//    public boolean recordIssue(Issue issue) {
//
//        Connection connection = DBUtil.getDBConnection();
//        String query = "INSERT INTO ISSUE_TBL VALUES(?,?,?,?,?,?)";
//
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//
//            ps.setInt(1, issue.getIssueID());
//            ps.setString(2, issue.getBookID());
//            ps.setString(3, issue.getStudentID());
//            ps.setString(4, issue.getStudentName());
//
//            Date issueDate = new Date(issue.getIssueDate().getTime());
//            ps.setDate(5, issueDate);
//
//            ps.setDate(6, null);
//
//            int result = ps.executeUpdate();
//
//            if (result > 0) {
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean closeIssue(int issueID) {
//
//        Connection connection = DBUtil.getDBConnection();
//        String query =
//                "UPDATE ISSUE_TBL SET RETURN_DATE=SYSDATE WHERE ISSUE_ID=?";
//
//        try {
//            PreparedStatement ps = connection.prepareStatement(query);
//            ps.setInt(1, issueID);
//
//            int result = ps.executeUpdate();
//
//            if (result > 0) {
//                return true;
//            } else {
//                return false;
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//}
