package jjjs.byj.domain;

import java.io.Serializable;

/**
 * @author： BaYongJian
 * @date 2019-12-03 19:48
 */
public class Book implements Serializable {

    private String bookName;
    private String bookWriter;
    private Integer bookTotal;
    private Integer bookRemaining;
    private Integer bookTimeout;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public Integer getBookTotal() {
        return bookTotal;
    }

    public void setBookTotal(Integer bookTotal) {
        this.bookTotal = bookTotal;
    }

    public Integer getBookRemaining() {
        return bookRemaining;
    }

    public void setBookRemaining(Integer bookRemaining) {
        this.bookRemaining = bookRemaining;
    }

    public Integer getBookTimeout() {
        return bookTimeout;
    }

    public void setBookTimeout(Integer bookTimeout) {
        this.bookTimeout = bookTimeout;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", bookWriter='" + bookWriter + '\'' +
                ", bookTotal=" + bookTotal +
                ", bookRemaining=" + bookRemaining +
                '}';
    }
}
