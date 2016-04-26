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
    String getWH(int n){
        StringBuffer str = new StringBuffer("(");
        for(int i = 1;i<=n;i++){
            str.append("?").append(i==n? ")":",");
        }
        return str.toString();
    }
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Good>findGood(String []province,String findData,Integer pageNum) {
        System.out.println(pageNum);
        int num = province.length;
        StringBuffer sql = new StringBuffer("select * from goods where ischeck = 1 and isshelf = 1 ");
        if(province.length>0){
            sql.append((new StringBuffer(" and province in ")).append(getWH(province.length)));
        }
        if(findData!=null && findData.length()>0){
            sql.append((new StringBuffer(" and goodname = ? ")));
            num++;
        }
        sql.append(" order by point ");
        sql.append("limit "+String.valueOf(pageNum*5)+",5 ");
        System.out.println(sql);
        Object[] params = new Object[num];
        for(int i=0;i<province.length;i++) params[i]=province[i];
        if(findData!=null && findData.length()>0)params[num-1] = findData;
        List<Good> ans = jdbcTemplate.query(sql.toString(),params, new GoodRowMapper());

        return  (ans != null && ans.size() > 0) ? ans : null;
    }

    public List<Good> getAll(){
        String sql= "select * from goods where ischeck = 1 and isshelf =1";
        Object[] params = new Object[] {};
        List<Good> ans = null;
        ans =jdbcTemplate.query(sql,params, new GoodRowMapper());
        return (ans != null && ans.size() > 0) ? ans : null;
    }
    public Good findById(Integer _id){
        String sql = "select * from goods where id = ?";
        Object[] params = new Object[] {_id};
        final Good tmp= new Good();
        jdbcTemplate.query(sql,params,new RowCallbackHandler(){
            public void processRow(ResultSet rs) throws SQLException {
                tool(rs,tmp);
            }
        });
        return tmp.getId()==-1 ?  null:tmp;
    }
    public List<Good> findByUserId(int id){
        String sql = "select * from goods where user_id = ?";
        Object[] params = new Object[] {id};
        List<Good> ans = null;
        ans =jdbcTemplate.query(sql,params, new GoodRowMapper());
        return (ans != null && ans.size() > 0) ? ans : null;
    }
    public void add(Good tmp){
        String sqlStr = "insert into goods(goodname,user_id,pic_url,detailPlace,mes,point,ischeck,judge,create_time,tag,province,isshelf)" +
                " values(?,?,?,?,?,?,?,?,?,?,?,?) ";
        Object[] args = {tmp.getGoodname(),tmp.getUser_id(),tmp.getPic_url(),tmp.getDetailPlace(),tmp.getMes(),tmp.getPoint(),tmp.getIscheck(),
                tmp.getJudge(),tmp.getCreate_time(),tmp.getTag(),tmp.getProvince(),tmp.getIsshelf()};
        jdbcTemplate.update(sqlStr, args);
    }
    public void update(Good tmp){
        String sqlStr = "UPDATE goods SET goodname=?,pic_url=?,mes=?"
                + " WHERE id =?";
        Object[] args = {tmp.getGoodname(),tmp.getPic_url(),tmp.getMes()};
        jdbcTemplate.update(sqlStr, args);
    }
    public void delete(Good tmp){
        //
    }
    public class GoodRowMapper implements RowMapper<Good> {
        @Override
        public Good mapRow(ResultSet rs, int rowNum) throws SQLException {
            Good tmp = new Good();
            tmp.setId(rs.getInt("id"));
            tmp.setGoodname(rs.getString("goodname"));
            tmp.setUser_id(rs.getInt("user_id"));
            tmp.setPic_url(rs.getString("pic_url"));
            tmp.setDetailPlace(rs.getString("detailPlace"));
            tmp.setMes(rs.getString("mes"));
            tmp.setPoint(rs.getInt("point"));
            tmp.setJudge(rs.getString("judge"));
            tmp.setIscheck(rs.getInt("ischeck"));
            tmp.setCreate_time(rs.getTimestamp("create_time"));
            tmp.setTag(rs.getString("tag"));
            tmp.setProvince(rs.getString("province"));
            tmp.setIsshelf(rs.getInt("isshelf"));
            tmp.setNumber(rs.getInt("number"));
            tmp.setPrice(rs.getDouble("price"));
            tmp.setTradenum(rs.getInt("tradeNum"));
            tmp.to();
            return tmp;
        }
    }
    public void  tool(ResultSet rs,Good ans)throws SQLException{
        ans.setId(rs.getInt("id"));
        ans.setGoodname(rs.getString("goodname"));
        ans.setUser_id(rs.getInt("user_id"));
        ans.setPic_url(rs.getString("pic_url"));
        ans.setDetailPlace(rs.getString("detailPlace"));
        ans.setMes(rs.getString("mes"));
        ans.setPoint(rs.getInt("point"));
        ans.setJudge(rs.getString("judge"));
        ans.setIscheck(rs.getInt("ischeck"));
        ans.setCreate_time(rs.getTimestamp("create_time"));
        ans.setTag(rs.getString("tag"));
        ans.setProvince(rs.getString("province"));
        ans.setIsshelf(rs.getInt("isshelf"));
        ans.setNumber(rs.getInt("number"));
        ans.setPrice(rs.getDouble("price"));
        ans.setTradenum(rs.getInt("tradeNum"));
        ans.to();
    }
}
