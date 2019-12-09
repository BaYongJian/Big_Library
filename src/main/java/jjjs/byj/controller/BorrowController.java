package jjjs.byj.controller;

import jjjs.byj.domain.Book;
import jjjs.byj.domain.Borrow;
import jjjs.byj.services.IBookService;
import jjjs.byj.services.IBorrowService;
import jjjs.byj.services.IUserService;
import jjjs.byj.services.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author： BaYongJian
 * @date 2019-12-06 11:51
 */
@Controller
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private IBorrowService borrowService;

    @Autowired
    private IBookService bookService;

    @Autowired
    private IUserService userService;

    /**
     * 根据书名查询借阅该书籍的账户
     * 管理员操作
     * @param borrowBookName
     * @param model
     * @return
     */
    @RequestMapping("/findByBookName")
    public String findByBookName(String borrowBookName, Model model){
        List<Borrow> borrowUsers = borrowService.findByBookName(borrowBookName);
        if(borrowUsers.isEmpty()){
            return "Error/Borrow/BookNotBorrowed";
        }
        for(Borrow borrow:borrowUsers){
            Date date = new Date();
            if(date.getTime() - borrow.getBorrowBookTime().getTime() > 15 * 24 * 3600 * 1000){
                borrow.setWhetherBookout(1);
            }
        }
        model.addAttribute("borrows",borrowUsers);
        return "Borrow/Admin/SelectBorrowUser";
    }

    /**
     * 根据账户查询借阅过的书籍
     * 管理员操作
     * @param borrowUserName
     * @param model
     * @return
     */
    @RequestMapping("/findByUserName")
    public String findByUserName(String borrowUserName,Model model){
        List<Borrow> borrowBooks = borrowService.findByUserName(borrowUserName);
        if(borrowBooks.isEmpty()){
            return "Error/Borrow/NoBookBorrowedError";
        }
        for(Borrow borrow:borrowBooks){
            Date date = new Date();
            if(date.getTime() - borrow.getBorrowBookTime().getTime() > 15 * 24 * 3600 * 1000){
                borrow.setWhetherBookout(1);
            }
        }
        model.addAttribute("borrows",borrowBooks);
        return "Borrow/Admin/SelectBorrowBook";
    }

    /**
     * 根据书名查询超时未归还账号
     * 管理员操作
     * @param borrowBookName
     * @param model
     * @return
     */
    @RequestMapping("/findBorrowBookTimeoutUserByBookName")
    public String findBorrowBookTimeoutUserByBookName(String borrowBookName,Model model){
        List<Borrow> borrowUsers = borrowService.findByBookName(borrowBookName);
        if(borrowUsers.isEmpty()){
            return "Error/Borrow/BookNotBorrowed";
        }
        List<Borrow> borrows = new LinkedList<>();
        for(Borrow borrow:borrowUsers){
            Date date = new Date();
            if(date.getTime() - borrow.getBorrowBookTime().getTime() > 15 * 24 * 3600 * 1000){
                borrows.add(borrow);
            }
        }
        model.addAttribute("borrows",borrows);
        return "Borrow/Admin/SelectBorrowTimeoutUser";
    }

    /**
     * 查询所有超时未还书账号
     * 管理员操作
     * @param model
     * @return
     */
    @RequestMapping("/findAllBookTimeoutUser")
    public String findAllBookTimeoutUser(Model model){
        List<Borrow> borrows = borrowService.findAll();
        List<Borrow> bookTimeoutUsers = new LinkedList<>();
        for(Borrow borrow : borrows){
            Date date = new Date();
            if(date.getTime() - borrow.getBorrowBookTime().getTime() > 15 * 24 * 3600 * 1000){
                bookTimeoutUsers.add(borrow);
            }
            model.addAttribute("borrows",bookTimeoutUsers);
        }
        return "Borrow/Admin/SelectAllBorrowTimeoutUser";
    }

    /**
     * 根据账户名称、书籍名称借阅
     * @param userName
     * @param bookName
     * @param model
     * @return
     */
    @RequestMapping("borrowBookByUser")
    public String borrowBookByUser(String userName,String bookName,Model model){
        try {
            Borrow borrow = borrowService.findByBookNAmeAndUserNAme(bookName,userName);
        }catch (Exception e){
            Borrow borrow1 = new Borrow();
            borrow1.setBorrowBookName(bookName);
            borrow1.setBorrowUserName(userName);
            Date date = new Date();
            borrow1.setBorrowBookTime(new java.sql.Date(date.getTime()));
            borrow1.setReturnBookTime(new java.sql.Date(date.getTime() + 15 * 24 * 3600 * 1000));

            Book book = bookService.findByName(bookName);
            if(book.getBookRemaining() == 0){
                return "Error/Book/BookRemainingNullError";
            }
            bookService.borrowBook(bookName);

            userService.borrowUser(userName);

            borrowService.borrowBookByUser(borrow1);
            return "Success/BorrowSuccess";
        }
        return "Error/Borrow/HadBorrowedError";
    }
}
