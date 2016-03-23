package com.shuly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.shuly.tool.pojo.Good;
import java.util.List;
/**
 * Created by shuly on 16-3-01.
 */
@Repository
public class GoodsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Good> getAll(){
        String sql= "select * from goods";
        Object[] params = new Object[] {};
        List<Good> ans = null;
        ans =jdbcTemplate.query(sql,params, new GoodRowMapper());
        return (ans != null && ans.size() > 0) ? ans : null;
    }
    public Good findById(int _id){
        String sql = "select * from goods where id = ?";
        Object[] params = new Object[] {_id};
        final Good ans= new Good();
        jdbcTemplate.query(sql,params,new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
                ans.setId(rs.getInt("id"));
                ans.setName(rs.getString("name"));
                ans.setUser_telnum(rs.getString("user_telnum"));
                ans.setPic_url(rs.getString("pic_url"));
                ans.setMes(rs.getString("mes"));
                ans.setCreate_time(rs.getTimestamp("create_time"));
            }
        });
        return ans;
    }
    public Good findByUserTelnum(String userTelnum){
        String sql = "select * from goods where user_telnum = ?";
        Object[] params = new Object[] {userTelnum};
        final Good ans= new Good();
        jdbcTemplate.query(sql,params,new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
                ans.setId(rs.getInt("id"));
                ans.setName(rs.getString("name"));
                ans.setUser_telnum(rs.getString("user_telnum"));
                ans.setPic_url(rs.getString("pic_url"));
                ans.setMes(rs.getString("mes"));
                ans.setCreate_time(rs.getTimestamp("create_time"));
            }
        });
        return ans;
    }
    public class GoodRowMapper implements RowMapper<Good> {
        @Override
        public Good mapRow(ResultSet rs, int rowNum) throws SQLException {
            Good tmp = new Good();
            tmp.setId(rs.getInt("id"));
            tmp.setName(rs.getString("name"));
            tmp.setUser_telnum(rs.getString("user_telnum"));
            tmp.setPic_url(rs.getString("pic_url"));
            tmp.setMes(rs.getString("mes"));
            tmp.setCreate_time(rs.getTimestamp("create_time"));
            return tmp;
        }
    }
}
