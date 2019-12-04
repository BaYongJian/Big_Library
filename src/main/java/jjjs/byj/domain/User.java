package jjjs.byj.domain;

import java.io.Serializable;

/**
 * @author： BaYongJian
 * @date 2019-12-03 19:55
 */
public class User implements Serializable {

    private String userName;
    private String password;
    private Integer permission;
    private Integer borrowBook;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }
    public Integer getBorrowBook() {
        return borrowBook;
    }

    public void setBorrowBook(Integer borrowBook) {
        this.borrowBook = borrowBook;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                ", borrowBook=" + borrowBook +
                '}';
    }
}
