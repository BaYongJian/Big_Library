package jjjs.byj.domain;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author： BaYongJian
 * @date 2019-12-03 19:57
 */
public class Borrow implements Serializable {

    private String borrowUserName;
    private String borrowBookName;
    private Date borrowBookTime;
    private Date returnBookTime;

    public String getBorrowUserName() {
        return borrowUserName;
    }

    public void setBorrowUserName(String borrowUserName) {
        this.borrowUserName = borrowUserName;
    }

    public String getBorrowBookName() {
        return borrowBookName;
    }

    public void setBorrowBookName(String borrowBookName) {
        this.borrowBookName = borrowBookName;
    }

    public Date getBorrowBookTime() {
        return borrowBookTime;
    }

    public void setBorrowBookTime(Date borrowBookTime) {
        this.borrowBookTime = borrowBookTime;
    }

    public Date getReturnBookTime() {
        return returnBookTime;
    }

    public void setReturnBookTime(Date returnBookTime) {
        this.returnBookTime = returnBookTime;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "borrowUserName='" + borrowUserName + '\'' +
                ", borrowBookName='" + borrowBookName + '\'' +
                ", borrowBookTime=" + borrowBookTime +
                ", returnBookTime=" + returnBookTime +
                '}';
    }
}
