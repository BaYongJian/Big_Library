package jjjs.byj.controller;

import jjjs.byj.domain.Book;
import jjjs.byj.domain.Borrow;
import jjjs.byj.services.IBookService;
import jjjs.byj.services.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author： BaYongJian
 * @date 2019-12-06 08:51
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService bookService;

    @Autowired
    private IBorrowService borrowService;

    /**
     * 查询所有书籍
     * 管理员操作
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Book> books = bookService.findAll();
        if(books == null){
            return "Error/Book/NullBookError";
        }
        for(Book book : books) {
            List<Borrow> borrows = borrowService.findByBookName(book.getBookName());
            for (Borrow borrow : borrows) {
                Date date = new Date();
                if (date.getTime() - borrow.getBorrowBookTime().getTime() > 15 * 24 * 3600 * 1000) {
                    book.setBookTimeout(1);
                }
            }
        }
        model.addAttribute("books",books);
        return "Book/Admin/SelectBook";
    }

    /**
     * 查询所有书籍
     * 普通用户操作
     * @param userName
     * @param model
     * @return
     */
    @RequestMapping("generalFindAll")
    public String generalFindAll(String userName,Model model){
        List<Book> books = bookService.findAll();
        if(books == null){
            return "Error/Book/NullBookError";
        }
        List<Borrow> borrows = borrowService.findByUserName(userName);
        for(Borrow borrow : borrows){
            for(Book book : books){
                if(book.getBookName().equals(borrow.getBorrowBookName())){
                    book.setBorrowOrNot(true);
                }
            }
        }
        model.addAttribute("books",books);
        return "Book/General/SelectBook";
    }

    /**
     * 根据名称查询书籍
     * 管理员操作
     * @param bookName
     * @param model
     * @return
     */
    @RequestMapping("/findByName")
    public String findByName(String bookName,Model model){
        Book book = bookService.findByName(bookName);
        if(book == null){
            return "Error/Book/NullBookError";
        }
        List<Book> books = new LinkedList<>();
        books.add(book);
        List<Borrow> borrows = borrowService.findByBookName(book.getBookName());
        for (Borrow borrow : borrows) {
            Date date = new Date();
            if (date.getTime() - borrow.getBorrowBookTime().getTime() > 15 * 24 * 3600 * 1000) {
                book.setBookTimeout(1);
            }
        }
        model.addAttribute("books",books);
        return "Book/Admin/SelectBook";
    }

    /**
     * 根据名称查询书籍
     * 普通用户操作
     * @param bookName
     * @param model
     * @return
     */
    @RequestMapping("generalFindByName")
    public String generalFindByName(String bookName,Model model){
        Book book = bookService.findByName(bookName);
        if(book == null){
            return "Error/Book/NullBookError";
        }
        List<Book> books = new LinkedList<>();
        books.add(book);
        model.addAttribute("books",books);
        return "Book/General/SelectBook";
    }

    /**
     * 添加书籍
     * 管理员操作
     * @param book
     * @return
     */
    @RequestMapping("/addBook")
    public String addBook(Book book){
        Book book1 = bookService.findByName(book.getBookName());
        if(book1 != null){
            return "Error/Book/BookOverHad";
        }
        book.setBookRemaining(book.getBookTotal());
        bookService.addBook(book);
        return "Success/AddSuccess";
    }

    /**
     * 删除书籍
     * 管理员操作
     * @param bookName
     * @return
     */
    @RequestMapping("/deleteBook")
    public String deleteBook(String bookName){
        Book book = bookService.findByName(bookName);
        if(book == null){
            return "Error/Book/NullBookError";
        }else if(book.getBookTotal() > book.getBookRemaining()){
            return "Error/Book/bookNotReturnError";
        }
        bookService.deleteBook(bookName);
        return "Success/DeleteSuccess";
    }

}
