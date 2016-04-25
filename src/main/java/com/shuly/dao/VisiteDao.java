package com.shuly.dao;

import com.shuly.tool.pojo.Mail;
import com.shuly.tool.pojo.Visite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by shuly on 16-3-01.
 */
@Repository
public class VisiteDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void add(Visite tmp){
        String sqlStr = "insert into visited(user_id,good_id,create_time,ip)" +
                " values(?,?,?,?) ";
        Object[] args = {tmp.getUser_id(),tmp.getGood_id(),tmp.getCreate_time(),tmp.getIp()};
        jdbcTemplate.update(sqlStr, args);
    }
    public List<Visite> findByUserId(int id){
        String sqlStr = "select * from visited where user_id = ? ";
        Object[] args = {id};
        List<Visite> ans = jdbcTemplate.query(sqlStr,args,new VisiteRowMapper());
        return  (ans != null && ans.size() > 0) ? ans : null;
    }
    public List<Visite> findByGoodId(int id){
        String sqlStr = "select * from visited where good_id = ? ";
        Object[] args = {id};
        List<Visite> ans = jdbcTemplate.query(sqlStr,args,new VisiteRowMapper());
        return  (ans != null && ans.size() > 0) ? ans : null;
    }
    public class VisiteRowMapper implements RowMapper<Visite> {
        @Override
        public Visite mapRow(ResultSet rs, int rowNum) throws SQLException {
            Visite tmp = new Visite();
            tmp.setId(rs.getInt("id"));
            tmp.setIp(rs.getString("ip"));
            tmp.setCreate_time(rs.getTimestamp("create_time"));
            tmp.setGood_id(rs.getInt("good_id"));
            tmp.setUser_id(rs.getInt("user_id"));
            return tmp;
        }
    }
}
