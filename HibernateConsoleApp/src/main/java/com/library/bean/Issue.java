package com.library.bean;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ISSUE_TBL")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "issue_seq")
    @SequenceGenerator(
            name = "issue_seq",
            sequenceName = "ISSUE_TBL_SEQ",
            allocationSize = 1
    )
    @Column(name = "ISSUE_ID")
    private int issueID;

    @Column(name = "BOOK_ID", nullable = false)
    private String bookID;

    @Column(name = "STUDENT_ID", nullable = false)
    private String studentID;

    @Column(name = "STUDENT_NAME", nullable = false)
    private String studentName;

    @Temporal(TemporalType.DATE)
    @Column(name = "ISSUE_DATE", nullable = false)
    private Date issueDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "RETURN_DATE")
    private Date returnDate;

    // Default constructor (required by Hibernate)
    public Issue() {
    }

    // Getters and Setters

    public int getIssueID() {
        return issueID;
    }

    public void setIssueID(int issueID) {
        this.issueID = issueID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueID=" + issueID +
                ", bookID='" + bookID + '\'' +
                ", studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
