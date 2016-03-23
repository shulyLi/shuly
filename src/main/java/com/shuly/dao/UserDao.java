package com.shuly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.shuly.tool.pojo.Good;
import com.shuly.tool.pojo.User;
import java.util.List;
/**
 * Created by shuly on 16-3-01.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int getMatchCount(String email, String password) {
        String sqlStr = " SELECT count(*) FROM user "
                + " WHERE emailr =? and password=? ";
        return jdbcTemplate.queryForInt(sqlStr, new Object[] { email, password });
    }
    public User findUserByUserName(final String userName) {
        String sqlStr = " SELECT * "
                + " FROM user WHERE username =? ";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[] { userName },
                new RowCallbackHandler() {
                    public void processRow(ResultSet rs) throws SQLException {
                        user.setId(rs.getInt("user_id"));
                        user.setUsername(rs.getString("username"));
                        user.setEmailr(rs.getString("emailr"));
                        user.setTelnum(rs.getString("telnum"));
                        user.setLevelr(rs.getInt("levelr"));
                        user.setCreate_time(rs.getTimestamp("create_time"));
                        user.setLast_visit_time(rs.getTimestamp("last_visit_time"));
                    }
                });
        return user;
    }
    public void updateLoginInfo(User user) {
        String sqlStr = " UPDATE user SET last_visit_time=?,last_ip=? "
                + " WHERE id =?";
        jdbcTemplate.update(sqlStr, new Object[] { user.getLast_visit_time(),
                user.getLast_ip()});
    }
    public void remove(User user){
    //
    }
    public void addUser(User user){
        String sqlStr = "insert into user(username,password,emailr,telnum,levelr,last_ip,create_time,last_visit_time)" +
                " values(?,?,?,?,?,?,?,?) ";
        Object[] args = {user.getUsername(),user.getPassword(),user.getEmailr(),user.getTelnum(),
                user.getLevelr(), user.getLast_ip(),user.getCreate_time(),user.getLast_visit_time()};
        jdbcTemplate.update(sqlStr, args);
    }
}
