package com.library.service;

import java.util.Date;

import com.library.bean.Book;
import com.library.bean.Issue;
import com.library.dao.BookDAO;
import com.library.dao.IssueDAO;

public class LibraryService {

    private BookDAO bookDAO = new BookDAO();
    private IssueDAO issueDAO = new IssueDAO();

    public String issueBook(String bookID, String studentID, String studentName) {

        try {

            if (bookID == null || studentID == null || studentName == null ||
                bookID.isEmpty() || studentID.isEmpty() || studentName.isEmpty()) {
                return "INVALID INPUT";
            }

            Book book = bookDAO.findBook(bookID);

            if (book == null) {
                return "BOOK NOT FOUND";
            }

            if (book.getAvailableCopies() == 0) {
                return "BOOK NOT AVAILABLE";
            }

            int updatedCopies = book.getAvailableCopies() - 1;
            boolean updated = bookDAO.updateAvailableCopies(bookID, updatedCopies);

            if (!updated) {
                return "FAILURE";
            }

            Issue issue = new Issue();
            issue.setBookID(bookID);
            issue.setStudentID(studentID);
            issue.setStudentName(studentName);
            issue.setIssueDate(new Date());
            issue.setReturnDate(null);

            boolean issueRecorded = issueDAO.recordIssue(issue);

            if (!issueRecorded) {
                return "FAILURE";
            }

            return "SUCCESS";

        } catch (Exception e) {
            return "FAILURE";
        }
    }

    public String returnBook(int issueID) {

        try {

            if (issueID <= 0) {
                return "INVALID ISSUE ID";
            }

            boolean result = issueDAO.closeIssue(issueID);

            if (!result) {
                return "INVALID ISSUE";
            }

            return "SUCCESS";

        } catch (Exception e) {
            return "FAILURE";
        }
    }
}







//package com.library.service;
//
//import java.util.Date;
//import com.library.bean.Book;
//import com.library.bean.Issue;
//import com.library.dao.BookDAO;
//import com.library.dao.IssueDAO;
//
//public class LibraryService {
//
//    private BookDAO bookDAO = new BookDAO();
//    private IssueDAO issueDAO = new IssueDAO();
//
//    public String issueBook(String bookID, String studentID, String studentName) {
//
//        try {
//
//            if (bookID == null || studentID == null || studentName == null ||
//                bookID.isEmpty() || studentID.isEmpty() || studentName.isEmpty()) {
//                return "INVALID INPUT";
//            }
//
//            Book book = bookDAO.findBook(bookID);
//
//            if (book == null) {
//                return "BOOK NOT FOUND";
//            }
//
//            if (book.getAvailableCopies() == 0) {
//                return "BOOK NOT AVAILABLE";
//            }
//
//            int updatedCopies = book.getAvailableCopies() - 1;
//            bookDAO.updateAvailableCopies(bookID, updatedCopies);
//
//            Issue issue = new Issue();
//            issue.setIssueID(issueDAO.generateIssueID());
//            issue.setBookID(bookID);
//            issue.setStudentID(studentID);
//            issue.setStudentName(studentName);
//            issue.setIssueDate(new Date());
//
//            issueDAO.recordIssue(issue);
//
//            return "SUCCESS";
//
//        } catch (Exception e) {
//            return "FAILURE";
//        }
//    }
//
//    public String returnBook(int issueID) {
//
//        try {
//
//            if (issueID <= 0) {
//                return "INVALID ISSUE ID";
//            }
//
//            boolean result = issueDAO.closeIssue(issueID);
//
//            if (result) {
//                return "SUCCESS";
//            } else {
//                return "INVALID ISSUE";
//            }
//
//        } catch (Exception e) {
//            return "FAILURE";
//        }
//    }
//}
