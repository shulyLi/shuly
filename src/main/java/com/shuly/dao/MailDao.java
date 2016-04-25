package com.shuly.dao;

import com.shuly.tool.pojo.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by shuly on 16-3-01.
 */
@Repository
public class MailDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int countNotReadMail(int id,Integer type){
        String Str="select count(1) from mail where owner_id = ? and isread = 0 and mailtype =?";
        Object[] args = {id,type};
        return jdbcTemplate.queryForInt(Str,args);
    }
    public void add(Mail Mail){
        String sqlStr = "insert into mail(owner_id,from_user,to_user,head,mes,create_time,isread,`mailtype`,fileRar)" +
                " values(?,?,?,?,?,?,?,?,?) ";
        Object[] args = {Mail.getOwner_id(),Mail.getFrom_user(),Mail.getTo_user(),Mail.getHead(),Mail.getMes(),Mail.getCreate_time(),
                        Mail.getIsread(),Mail.getMailtype(),Mail.getFilerar()};
        jdbcTemplate.update(sqlStr, args);
    }
    public void delete(int id){
        String sqlStr = "delete from mail where id =?";
        Object[] args = {id};
        jdbcTemplate.update(sqlStr,args);
    }
    public void updateState(int id,int type,int state){
        String sqlStr = "update mail set mailtype = ?,isread = ? where id =?";
        Object[] args = {type,state,id};
        jdbcTemplate.update(sqlStr, args);
    }
    public List<Mail> findMailByTypeOwner(int id,int type){
        String sqlStr = "select * from mail where owner_id = ? and mailtype = ? ";
        Object[] args = {id,type};
        List<Mail> ans = jdbcTemplate.query(sqlStr,args,new MailRowMapper());
        return ans;
    }
    public Mail findMailById(Integer id){
        String sql = "select * from mail where id = ?";
        Object[] params = new Object[] {id};
        final Mail ans= new Mail();
        jdbcTemplate.query(sql,params,new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
                ans.setId(rs.getInt("id"));
                ans.setOwner_id(rs.getInt("owner_id"));
                ans.setFrom_user(rs.getString("from_user"));
                ans.setTo_user(rs.getString("to_user"));
                ans.setHead(rs.getString("head"));
                ans.setMes(rs.getString("mes"));
                ans.setCreate_time(rs.getTimestamp("create_time"));
                ans.setIsread(rs.getInt("isread"));
                ans.setMailtype(rs.getInt("mailtype"));
                ans.setFilerar(rs.getString("fileRar"));
            }
        });
        return ans.getId()==-1?null:ans;
    }
    public class MailRowMapper implements RowMapper<Mail> {
        @Override
        public Mail mapRow(ResultSet rs, int rowNum) throws SQLException {
            Mail tmp = new Mail();
            tmp.setId(rs.getInt("id"));
            tmp.setOwner_id(rs.getInt("owner_id"));
            tmp.setFrom_user(rs.getString("from_user"));
            tmp.setTo_user(rs.getString("to_user"));
            tmp.setHead(rs.getString("head"));
            tmp.setMes(rs.getString("mes"));
            tmp.setCreate_time(rs.getTimestamp("create_time"));
            tmp.setIsread(rs.getInt("isread"));
            tmp.setMailtype(rs.getInt("mailtype"));
            tmp.setFilerar(rs.getString("fileRar"));
            return tmp;
        }
    }
}
