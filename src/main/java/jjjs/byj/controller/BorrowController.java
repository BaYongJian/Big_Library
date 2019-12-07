package jjjs.byj.controller;

import jjjs.byj.domain.Borrow;
import jjjs.byj.services.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
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

    /**
     * 根据书名查询借阅该书籍的账户
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
        model.addAttribute("borrows",borrowUsers);
        return "Borrow/SelectBorrowUser";
    }

    /**
     * 根据账户查询借阅过的书籍
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
        model.addAttribute("borrows",borrowBooks);
        return "Borrow/SelectBorrowBook";
    }
}
