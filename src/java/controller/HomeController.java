/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BookDAOImp;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Book;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author yoruk
 */
@Controller
public class HomeController {

    @Autowired
    private BookDAOImp bookDAOImp;

    @RequestMapping(value = {"/", "home"}, method = RequestMethod.GET)
    public String home(ModelMap modelMap) {
        List<Book> bookList = bookDAOImp.getAllBooks();
        modelMap.put("bookList", bookList);
        return "index";
    }

    @RequestMapping(value = "addBook", method = RequestMethod.GET)
    public ModelAndView addBook() {
        Book book = new Book();

        ModelAndView modelAndView = new ModelAndView("addBook", "command", book);
        return modelAndView;
    }

    @RequestMapping(value = "addBookToDatabase", method = RequestMethod.POST)
    public String addBookToDatabase(@ModelAttribute("SpringWeb") Book book,
            ModelMap model) {

        bookDAOImp.addBook(book);
        //model.addAttribute("bookname", book.getTitle());
        return "redirect:/"; //home page
    }

    @RequestMapping(value = "getBook", method = RequestMethod.GET)
    public String getBook(@RequestParam("id") String id, ModelMap model) {
        Book book = bookDAOImp.getBook(Integer.parseInt(id));
        model.addAttribute("book", book);
        return "viewBook";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login() {
        User user = new User();

        ModelAndView modelAndView = new ModelAndView("login", "command", user);
        return modelAndView;
    }

    @RequestMapping(value = "loginIsValid", method = RequestMethod.POST)
    public String loginIsValid(@ModelAttribute("SpringWeb") User user,
            HttpServletRequest request,
            ModelMap model) {

//        Cookie cookie = new Cookie("session_id", "");
//        cookie.setPath("/aciktim/");
        HttpSession session = request.getSession();
        session.setAttribute("ses", "session");
//        request.setAttribute("name", "model");
        if (bookDAOImp.login(user.getId())) {
            session.setAttribute("user_id", user.getId());
        }

        return "redirect:/"; //home page
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {

//        HttpSession session = request.getSession();
//        session.setAttribute("ses", "session");
//        request.setAttribute("name", "model");
        request.getSession().invalidate();

        return "redirect:/"; //home page
    }
    
    @RequestMapping(value = "hireBook", method = RequestMethod.GET)
    public String hireBook(@RequestParam("bookId") String bookId, HttpServletRequest request) {

//        HttpSession session = request.getSession();
//        session.setAttribute("ses", "session");
//        request.setAttribute("name", "model");
        int userId = (int) request.getSession().getAttribute("user_id");
        bookDAOImp.hireBook(userId, Integer.parseInt(bookId));
        return "redirect:/"; //home page
    }
    
    @RequestMapping(value = "getHiredBooks", method = RequestMethod.GET)
    public String getHiredBooks(HttpServletRequest request, ModelMap modelMap) {
        int userId = (int) request.getSession().getAttribute("user_id");
        List<Book> bookList = bookDAOImp.getHiredBooks(userId);
        
        //modelMap.put("hiredBookList", bookList); // bu da olur
        modelMap.addAttribute("hiredBookList", bookList);
        return "hiredBooks";
    }
    
    @RequestMapping(value = "takeBackBook", method = RequestMethod.GET)
    public String hireBook(@RequestParam("bookId") String bookId) {

//        HttpSession session = request.getSession();
//        session.setAttribute("ses", "session");
//        request.setAttribute("name", "model");
        bookDAOImp.takeBackBook(Integer.parseInt(bookId));
        return "redirect:/"; //home page
    }

//    @ModelAttribute("book")
//    public Book getWebFrameworkList() {
//        Book book = new Book(0, "bookname", "author", "summary", 0);
//
//        return book;
//    }
}
