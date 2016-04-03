package com.shuly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.shuly.tool.pojo.User;
import java.util.List;
/**
 * Created by shuly on 16-3-01.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCountForRegister(String email) {
        String sqlStr = " SELECT count(*) FROM user "
                + " WHERE emailr =? ";
        return jdbcTemplate.queryForInt(sqlStr, new Object[] { email });
    }
    public int getMatchCountForLogin(String email,String password){
        String sqlStr = " SELECT count(*) FROM user "
                + " WHERE emailr =? and password=? ";
        return jdbcTemplate.queryForInt(sqlStr, new Object[] { email,password });
    }
    public User getUserByEmail(String email){
        String sql = "select * from user where emailr = ?";
        Object[] params = new Object[] {email};
        final User ans= new User();
        jdbcTemplate.query(sql,params,new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
                ans.setId(rs.getInt("id"));
                ans.setUsername(rs.getString("username"));
                ans.setEmailr(rs.getString("emailr"));
                ans.setTelnum(rs.getString("telnum"));
                ans.setLevelr(rs.getInt("levelr"));
                ans.setCreate_time(rs.getTimestamp("create_time"));
                ans.setLast_visit_time(rs.getTimestamp("last_visit_time"));
            }
        });
        return ans;
    }
    public List<User> getUserByUserName(final String userName) {
        String sql = " SELECT * "
                + " FROM user WHERE username =? ";
        Object[] params = new Object[] {userName};
        List ans = null;
        ans =jdbcTemplate.query(sql,params, new UserRowMapper());
        return (ans != null && ans.size() > 0) ? ans : null;
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

    public class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmailr(rs.getString("emailr"));
            user.setTelnum(rs.getString("telnum"));
            user.setLevelr(rs.getInt("levelr"));
            user.setCreate_time(rs.getTimestamp("create_time"));
            user.setLast_visit_time(rs.getTimestamp("last_visit_time"));
            return user;
        }
    }



}
