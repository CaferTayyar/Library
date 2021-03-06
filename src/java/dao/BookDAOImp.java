/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 *
 * @author yoruk
 */
@Service
public class BookDAOImp implements BookDAO {

    private PlatformTransactionManager transactionManager;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private final static String INSERT_BOOK = "insert into books (id, title, author, summary, ownerid) values (:id, :title, :author, :summary, :ownerid)";
    private final static String SELECT_ALL_BOOKS = "select * from books";
    private final static String SELECT_BYID = "select * from books where id=:id";
    private final static String SELECT_USER_BYID = "select * from users where id=:id";
    private final static String UPDATE_BOOK = "update books set ownerid=:ownerid where id=:id";
    private final static String SELECT_HIRED_BOOKS = "select * from books where ownerid=:ownerid";

    @Autowired
    public void setDataSource(DataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Autowired
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    private TransactionStatus getTransactionStatus() {
        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
        return status;
    }

    @Override
    public boolean login(int userId) {
        TransactionStatus status = getTransactionStatus();
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", userId);
            map = namedParameterJdbcTemplate.queryForMap(SELECT_USER_BYID, namedParameters);
            
            // commit
            transactionManager.commit(status);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("rollback...");
            transactionManager.rollback(status);
        }

        return !map.isEmpty();
    }

    @Override
    public void takeBackBook(int bookId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ownerid", -1);
        params.put("id", bookId);

        namedParameterJdbcTemplate.update(UPDATE_BOOK, params);
    }

    @Override
    public void addBook(Book book) {
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("id", book.getId());
//        params.put("name", book.getName());
//        params.put("surname", book.getSurname());
//        params.put("birthYear", book.getBirthYear());

        SqlParameterSource params = new BeanPropertySqlParameterSource(book);

        //namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        namedParameterJdbcTemplate.update(INSERT_BOOK, params);
    }

    @Override
    public void hireBook(int userId, int bookId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ownerid", userId);
        params.put("id", bookId);

        namedParameterJdbcTemplate.update(UPDATE_BOOK, params);
    }

    @Override
    public Book getBook(int bookId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", bookId);
        Book book = (Book) namedParameterJdbcTemplate.queryForObject(SELECT_BYID, namedParameters, new BookRowMapper());
        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        //namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        List<Book> bookList = namedParameterJdbcTemplate.query(SELECT_ALL_BOOKS, new BookRowMapper());
        return bookList;
    }

    @Override
    public List<Book> getHiredBooks(int userId) {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("ownerid", userId);
        List<Book> bookList = namedParameterJdbcTemplate.query(SELECT_HIRED_BOOKS, namedParameters, new BookRowMapper());
        return bookList;
    }
}
