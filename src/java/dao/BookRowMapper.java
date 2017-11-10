/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Book;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author yoruk
 */
public class BookRowMapper implements RowMapper {

    @Override
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        int id = resultSet.getInt("id");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        String summary = resultSet.getString("summary");
        int ownerid = resultSet.getInt("ownerid");

        Book book = new Book(id, title, author, summary, ownerid);
        return book;
    }
}
