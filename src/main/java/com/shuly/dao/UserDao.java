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
    public void updateBeMan(Integer id,String name,String tel,String add){
        String strSql = "update user set levelr = levelr|2,realname=?,telnum=?,`add`=? where id =?;";
        Object[] arg={name,tel,add,id};
        jdbcTemplate.update(strSql,arg);
    }
    public int getMatchCountForRegister(String telnum,String name) {
        String sqlStr = " SELECT count(*) FROM user "
                + " WHERE telnum =? or username =?";
        return jdbcTemplate.queryForInt(sqlStr, new Object[] { telnum,name});
    }
    public User getForLogin(String name,String password){
        String sqlStr = " SELECT * FROM user "
                + " WHERE `username` =? and password=? ";
        final User ans= new User();
        jdbcTemplate.query(sqlStr, new Object[] { name,password },new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
                tool(rs,ans);
            }
        });
        return ans.getId()==-1?null:ans;
    }
    public User getById(Integer id){
        String sql = "select * from user where id = ?";
        Object[] params = new Object[] {id};
        final User ans= new User();
        jdbcTemplate.query(sql,params,new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
                tool(rs,ans);
            }
        });
        return ans.getId()==-1?null:ans;
    }
    public User getByName(String name){
        String sql = "select * from user where username = ?";
        Object[] params = new Object[] {name};
        final User ans= new User();
        jdbcTemplate.query(sql,params,new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
                tool(rs,ans);
            }
        });
        return ans.getId()==-1?null:ans;
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
        /*
        String sqlStr = " UPDATE user SET last_visit_time=?,last_ip=? "
                + " WHERE id =?";
        jdbcTemplate.update(sqlStr, new Object[] { user.getLast_visit_time(),
                user.getLast_ip()});
                )*/
    }
    public void point(Integer point,Integer id){
        String sqlStr = "UPDATE user set point=point+? where id =?";
        Object[] args = {point,id};
        jdbcTemplate.update(sqlStr,args);
    }
    public void remove(User user){
    //
    }
    public void addUser(User user){
        String sqlStr = "insert into user(username,password,emailr,telnum,`add`,levelr,point,utype,ischeck,last_visit_time,create_time" +
                ",pic)" +
                " values(?,?,?,?,?,?,?,?,?,?,?,?) ";
        Object[] args = {user.getUsername(),user.getPassword(),user.getEmailr(),user.getTelnum(),user.getAdd(),user.getLevelr(),user.getPoint(),
                user.getUtype(),user.getIscheck(),user.getLast_visit_time(),user.getCreate_time(),user.getPic()};
        jdbcTemplate.update(sqlStr, args);
    }
    public class UserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setEmailr(rs.getString("emailr"));
            user.setAdd(rs.getString("add"));
            user.setTelnum(rs.getString("telnum"));
            user.setLevelr(rs.getInt("levelr"));
            user.setPoint(rs.getInt("point"));
            user.setUtype(rs.getInt("utype"));
            user.setIscheck(rs.getInt("ischeck"));
            user.setCreate_time(rs.getTimestamp("create_time"));
            user.setLast_visit_time(rs.getTimestamp("last_visit_time"));
            user.setPic(rs.getString("pic"));
            return user;
        }
    }
    public void  tool(ResultSet rs,User ans)throws SQLException{
        ans.setId(rs.getInt("id"));
        ans.setUsername(rs.getString("username"));
        ans.setEmailr(rs.getString("emailr"));
        ans.setAdd(rs.getString("add"));
        ans.setTelnum(rs.getString("telnum"));
        ans.setLevelr(rs.getInt("levelr"));
        ans.setPoint(rs.getInt("point"));
        ans.setUtype(rs.getInt("utype"));
        ans.setIscheck(rs.getInt("ischeck"));
        ans.setCreate_time(rs.getTimestamp("create_time"));
        ans.setLast_visit_time(rs.getTimestamp("last_visit_time"));
        ans.setPic(rs.getString("pic"));
    }
}
