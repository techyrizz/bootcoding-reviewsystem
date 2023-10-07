package com.bootcoding.review.reviewsystem.repository;

import com.bootcoding.review.reviewsystem.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
@Component
public class UserRepository {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
     public UserRepository(DataSource dataSource,
                           JdbcTemplate jdbcTemplate){
         this.dataSource = dataSource;
         this.jdbcTemplate = jdbcTemplate;
     }
    public void save(User user){
         try{
             String query = "INSERT into review-user"+
                     "values('" + user.getUsername() + "'"+
                     "'" + user.getEmailId() + "'" +
                             user.getPhoneNo()+")";
                     jdbcTemplate.update(query);
         }catch (Exception ex){
             ex.printStackTrace();
         }

    }
}
