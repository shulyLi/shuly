package com.shuly.dao;


import com.shuly.tool.pojo.Op;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by shuly on 16-4-27.
 */
@Repository
public class OpDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Op tmp){
        String sqlStr = "insert into op(user_id,to_id,type,reason,create_time,ip)" +
                " values(?,?,?,?,?,?) ";
        Object[] args = {tmp.getUser_id(),tmp.getTo_id(),tmp.getType(),tmp.getReason(),
                tmp.getCreate_time(),tmp.getIp()};
        jdbcTemplate.update(sqlStr, args);
    }
    public List<Op> getByUserId(Integer id){
        String sql= "select * from op where  user_id=? order by create_time desc  limit 28";
        Object[] params = new Object[] {id};
        List<Op> ans = null;
        ans =jdbcTemplate.query(sql,params, new OpRowMapper());
        return (ans != null && ans.size() > 0) ? ans : null;
    }
    public List<Op> getByUserIdLimit(Integer id){
        String sql= "select * from op where  user_id=? and type in(1,2,3) order by create_time desc  limit 28";
        Object[] params = new Object[] {id};
        List<Op> ans = null;
        ans =jdbcTemplate.query(sql,params, new OpRowMapper());
        return (ans != null && ans.size() > 0) ? ans : null;
    }
    public class OpRowMapper implements RowMapper<Op> {
        @Override
        public Op mapRow(ResultSet rs, int rowNum) throws SQLException {
            Op tmp = new Op();
            tmp.setId(rs.getInt("id"));
            tmp.setUser_id(rs.getInt("user_id"));
            tmp.setTo_id(rs.getInt("to_id"));
            tmp.setType(rs.getInt("type"));
            tmp.setReason(rs.getString("reason"));
            tmp.setCreate_time(rs.getTimestamp("create_time"));
            tmp.setIp(rs.getString("ip"));
            return tmp;
        }
    }
}
