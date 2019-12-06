package jjjs.byj.controller;

import jjjs.byj.domain.Borrow;
import jjjs.byj.services.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        List<Borrow> borrows = borrowService.findByBookName(borrowBookName);
        if(borrows.isEmpty()){
            return "Error/Borrow/BookNotBorrowed";
        }
        model.addAttribute("borrows",borrows);
        return "Borrow/SelectBorrowUser";
    }
}
