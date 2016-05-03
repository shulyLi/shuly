package com.shuly.dao;


import com.shuly.tool.pojo.Deal;
import com.shuly.tool.pojo.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by shuly on 16-4-27.
 */
@Repository
public class LeaveDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void add(Leave in){
        String sqlStr="insert into leaveMes(from_user,toName,toId,isRight,lever,mes,create_time)" +
                "values(?,?,?,?,?,?,?)";
        Object[] arg={in.getFrom_user(),in.getToName(),in.getToId(),in.getIsRight(),
                        in.getLever(),in.getMes(),in.getCreate_time()};
        jdbcTemplate.update(sqlStr, arg);
    }
    public  void update(Integer id, Integer l,String msg,Timestamp c_time) {
        String sqlStr="update leaveMes set lever=?,mes=?,create_time=?,isRight=1 where id =?";
        Object[] arg={l,msg,c_time,id};
        jdbcTemplate.update(sqlStr, arg);
    }
    public List<Leave> getByGoodId(Integer id){
        String sqlStr= "select * from leaveMes where toId= ? and isRight = 1 order by create_time desc";
        Object []arg ={id};
        List<Leave>ans =jdbcTemplate.query(sqlStr,arg, new LeaveRowMapper());
        return (ans != null && ans.size() > 0) ? ans : null;
    }

    public List<Leave> getByUserId(Integer id){
        String sqlStr= "select * from leaveMes where from_user= ? order by create_time desc";
        Object []arg ={id};
        List<Leave>ans =jdbcTemplate.query(sqlStr,arg, new LeaveRowMapper());
        return (ans != null && ans.size() > 0) ? ans : null;
    }
    public Leave findById(Integer id){
        String sqlStr ="select * from leaveMes  where id =?";
        Object[] arg={id};
        final Leave tmp= new Leave();
        jdbcTemplate.query(sqlStr,arg,new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
                tool(rs,tmp);
            }
        });
        return tmp.getId()==-1 ?  null:tmp;
    }
    public Integer notGrade(Integer id){
        String Str="select count(1) from leaveMes where from_user = ? and isRight = 0";
        Object[] args = {id};
        return jdbcTemplate.queryForInt(Str,args);
    }
    public class LeaveRowMapper implements RowMapper<Leave> {
        @Override
        public Leave mapRow(ResultSet rs, int rowNum) throws SQLException {
            Leave tmp = new Leave();
            tmp.setId(rs.getInt("id"));
            tmp.setFrom_user(rs.getInt("from_user"));
            tmp.setToName(rs.getString("toName"));
            tmp.setToId(rs.getInt("toId"));
            tmp.setIsRight(rs.getInt("isRight"));
            tmp.setLever(rs.getInt("lever"));
            tmp.setMes(rs.getString("mes"));
            tmp.setCreate_time(rs.getTimestamp("create_time"));
            return tmp;
        }
    }
    public void  tool(ResultSet rs,Leave ans)throws SQLException{
        ans.setId(rs.getInt("id"));
        ans.setId(rs.getInt("id"));
        ans.setFrom_user(rs.getInt("from_user"));
        ans.setToName(rs.getString("toName"));
        ans.setToId(rs.getInt("toId"));
        ans.setIsRight(rs.getInt("isRight"));
        ans.setLever(rs.getInt("lever"));
        ans.setMes(rs.getString("mes"));
        ans.setCreate_time(rs.getTimestamp("create_time"));
    }
}
