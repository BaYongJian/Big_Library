package jjjs.byj.domain;

import java.io.Serializable;

/**
 * @author： BaYongJian
 * @date 2019-12-03 19:48
 */
public class Book implements Serializable {

    private String bookName;
    private String writerName;
    private Integer bookTotal;
    private Integer bookRemaining;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
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

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", writerName='" + writerName + '\'' +
                ", bookTotal=" + bookTotal +
                ", bookRemaining=" + bookRemaining +
                '}';
    }
}
