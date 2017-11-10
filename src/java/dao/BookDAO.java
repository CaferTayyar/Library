/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Book;

/**
 *
 * @author yoruk
 */
public interface BookDAO {
    public boolean login(int userId);
    public void takeBackBook(int bookId);
    public void addBook(Book book);
    public void hireBook(int userId, int bookId);
    public Book getBook(int bookId);
    public List<Book> getAllBooks();
    public List<Book> getHiredBooks(int userId);
}
