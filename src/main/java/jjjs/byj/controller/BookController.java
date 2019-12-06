package jjjs.byj.controller;

import jjjs.byj.domain.Book;
import jjjs.byj.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    /**
     * 查询所有书籍
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Book> books = bookService.findAll();
        if(books == null){
            return "Error/Book/NullBookError";
        }
        model.addAttribute("books",books);
        return "Book/SelectBook";
    }

    /**
     * 根据名称查询书籍
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
        model.addAttribute("books",books);
        return "Book/SelectBook";
    }

    /**
     * 添加书籍
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
