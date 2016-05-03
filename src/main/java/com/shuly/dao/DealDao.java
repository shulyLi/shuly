package com.shuly.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.shuly.tool.pojo.Deal;
import java.util.List;
/**
 * Created by shuly on 16-4-27.
 */
@Repository
public class DealDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(Deal in){
        String sqlStr = "insert into deal(good_id,owner_id,user_id,`add`,detailAdd,buyName,buyPhone,num," +
                "goodPrice,tradePrice,states,create_time)" +
                " values(?,?,?,?,?,?,?,?,?,?,?,?) ";
        Object[] args = {in.getGood_id(),in.getOwner_id(),in.getUser_id(),
                in.getAdd(),in.getDetailAdd(),in.getBuyName(),in.getBuyPhone(),
                in.getNum(),in.getGoodPrice(),in.getTradePrice(),in.getStates(),in.getCreate_time()};
        jdbcTemplate.update(sqlStr, args);
    }
    public List<Deal> getFromMyDeal(Integer id){
        String sql= "select * from deal where user_id=?";
        Object[] params = new Object[] {id};
        List<Deal> ans = null;
        ans =jdbcTemplate.query(sql,params, new DealRowMapper());
        return (ans != null && ans.size() > 0) ? ans : null;
    }
    public List<Deal> all(){
        String sql= "select * from deal";
        List<Deal> ans =jdbcTemplate.query(sql, new DealRowMapper());
        return (ans != null && ans.size() > 0) ? ans : null;
    }
    public List<Deal> getToMyDeal(Integer id){
        String sql= "select * from deal where owner_id=?";
        Object[] params = new Object[] {id};
        List<Deal> ans = null;
        ans =jdbcTemplate.query(sql,params, new DealRowMapper());
        return (ans != null && ans.size() > 0) ? ans : null;
    }
    public void updateState(Integer id,Integer type){
        String strSql = "update deal set states= ?  where id =?";
        Object[] args={type,id};
        jdbcTemplate.update(strSql,args);
    }
    public Deal getById(Integer id){
        String sql= "select * from deal where id=?";
        Object[] params = new Object[] {id};
        final Deal tmp= new Deal();
        jdbcTemplate.query(sql,params,new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
                tool(rs,tmp);
            }
        });
        return tmp.getId()==-1 ?  null:tmp;
    }
    public class DealRowMapper implements RowMapper<Deal> {
        @Override
        public Deal mapRow(ResultSet rs, int rowNum) throws SQLException {
            Deal tmp = new Deal();
            tmp.setId(rs.getInt("id"));
            tmp.setGood_id(rs.getInt("good_id"));
            tmp.setOwner_id(rs.getInt("owner_id"));
            tmp.setUser_id(rs.getInt("user_id"));
            tmp.setAdd(rs.getString("add"));
            tmp.setDetailAdd(rs.getString("detailAdd"));
            tmp.setBuyName(rs.getString("buyName"));
            tmp.setBuyPhone(rs.getString("buyPhone"));
            tmp.setNum(rs.getInt("num"));
            tmp.setGoodPrice(rs.getDouble("goodPrice"));
            tmp.setTradePrice(rs.getDouble("tradePrice"));
            tmp.setStates(rs.getInt("states"));
            tmp.setCreate_time(rs.getTimestamp("create_time"));
            tmp.setIsMes(rs.getInt("isMes"));
            return tmp;
        }
    }
    public void  tool(ResultSet rs,Deal ans)throws SQLException{
        ans.setId(rs.getInt("id"));
        ans.setGood_id(rs.getInt("good_id"));
        ans.setOwner_id(rs.getInt("owner_id"));
        ans.setUser_id(rs.getInt("user_id"));
        ans.setAdd(rs.getString("add"));
        ans.setDetailAdd(rs.getString("detailAdd"));
        ans.setBuyName(rs.getString("buyName"));
        ans.setBuyPhone(rs.getString("buyPhone"));
        ans.setNum(rs.getInt("num"));
        ans.setGoodPrice(rs.getDouble("goodPrice"));
        ans.setTradePrice(rs.getDouble("tradePrice"));
        ans.setStates(rs.getInt("states"));
        ans.setCreate_time(rs.getTimestamp("create_time"));
        ans.setIsMes(rs.getInt("isMes"));
    }

}
