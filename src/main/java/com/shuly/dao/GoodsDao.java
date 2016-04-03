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
    public List<Good> getGoodByPointAndLimit(int limi){

        String sql = "select * from goods order by point limit ?";
        List<Good> ans = null;
        ans =jdbcTemplate.query(sql,new Object[]{limi}, new GoodRowMapper());
        return (ans != null && ans.size() > 0) ? ans : null;
    }

    public Good findById(int _id){
        String sql = "select * from goods where id = ?";
        Object[] params = new Object[] {_id};
        final Good tmp= new Good();
        jdbcTemplate.query(sql,params,new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
                tmp.setId(rs.getInt("id"));
                tmp.setGoodname(rs.getString("goodname"));
                tmp.setUser_id(rs.getInt("user_id"));
                tmp.setUser_telnum(rs.getString("user_telnum"));
                tmp.setPic_url(rs.getString("pic_url"));
                tmp.setMes(rs.getString("mes"));
                tmp.setPoint(rs.getInt("point"));
                tmp.setCreate_time(rs.getTimestamp("create_time"));

            }
        });
        return tmp;
    }
    public List<Good> findByUserTelnum(String userTelnum){
        String sql = "select * from goods where user_telnum = ?";
        Object[] params = new Object[] {userTelnum};
        List<Good> ans = null;
        ans =jdbcTemplate.query(sql,new Object[]{userTelnum}, new GoodRowMapper());
        return (ans != null && ans.size() > 0) ? ans : null;
    }
    public void add(Good tmp){
        String sqlStr = "insert into goods(goodname,user_id,user_telnum,pic_url,mes,point,create_time)" +
                " values(?,?,?,?,?,?,?) ";
        Object[] args = {tmp.getGoodname(),tmp.getUser_id(),tmp.getUser_telnum(),tmp.getPic_url(),
                tmp.getMes(), tmp.getPoint(),tmp.getCreate_time()};
        jdbcTemplate.update(sqlStr, args);
    }
    public void update(Good tmp){
        String sqlStr = "UPDATE goods SET goodname=?,pic_url=?,mes=?"
                + " WHERE id =?";
        Object[] args = {tmp.getGoodname(),tmp.getPic_url(),tmp.getMes()};
        jdbcTemplate.update(sqlStr, args);
    }
    public void delete(Good tmp){

    }
    public class GoodRowMapper implements RowMapper<Good> {
        @Override
        public Good mapRow(ResultSet rs, int rowNum) throws SQLException {
            Good tmp = new Good();
            tmp.setId(rs.getInt("id"));
            tmp.setGoodname(rs.getString("goodname"));
            tmp.setUser_id(rs.getInt("user_id"));
            tmp.setUser_telnum(rs.getString("user_telnum"));
            tmp.setPic_url(rs.getString("pic_url"));
            tmp.setMes(rs.getString("mes"));
            tmp.setPoint(rs.getInt("point"));
            tmp.setCreate_time(rs.getTimestamp("create_time"));
            return tmp;
        }
    }
}
