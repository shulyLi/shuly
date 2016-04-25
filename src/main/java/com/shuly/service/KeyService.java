package com.shuly.service;

import com.shuly.dao.GoodsDao;
import com.shuly.dao.MailDao;
import com.shuly.dao.UserDao;
import com.shuly.dao.VisiteDao;
import com.shuly.tool.pojo.Good;
import com.shuly.tool.pojo.Mail;
import com.shuly.tool.pojo.User;
import com.shuly.tool.pojo.Visite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuly on 16-3-22.
 */
@Service
public class KeyService {
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    UserDao userDao;
    @Autowired
    VisiteDao visiteDao;
    @Autowired
    MailDao mailDao;
    public boolean isRegisterOk(User user){
        return userDao.getMatchCountForRegister(user.getTelnum(),user.getUsername())==0;
    }
    public void register(User user){
        userDao.addUser(user);
    }
    public User isLogin(String name,String password){
        return userDao.getForLogin(name,password);
    }
    public User getUserByEmail(String email){
        return userDao.getUserByEmail(email);
    }
    public void updateUser(User user){

    }
    public User findUserByName(String name){
        return userDao.getByName(name);
    }
    /* good*/
    public void addGood(Good good){
        goodsDao.add(good);
    }
    public void changeGood(Good tmp){
        goodsDao.update(tmp);
    }
    public Good findGoodById(Integer goodId){
        return goodsDao.findById(goodId);
    }
    public Good findGoodById(Integer goodId,int userId,String IP){
        Visite tmp = new Visite();
        tmp.setGood_id(goodId);
        tmp.setUser_id(userId);
        tmp.setIp(IP);
        tmp.setCreate_time(new Timestamp(System.currentTimeMillis()));
        visiteDao.add(tmp);
        return goodsDao.findById(goodId);
    }
    public List<Good>findGood(String []province,String findData,Integer pageNum){
        return goodsDao.findGood(province,findData,pageNum);
    }
    public List<Good>findGoodByUser(int id){
        return goodsDao.findByUserId(id);
    }
    /*
    public List<Good>  getGoods(){

    }
    */

    /*mail*/
    public List<Mail> findMailByTypeOwner(Integer type,int id){
        return mailDao.findMailByTypeOwner(id,type);
    }
    public int [] countNotReadMail(int id){
        int [] ans =new int[4];
        ans[0]=mailDao.countNotReadMail(id,1);
        ans[1]=mailDao.countNotReadMail(id,5);
        ans[2]=mailDao.countNotReadMail(id,6);
        return ans;
    }
    public void addMail(Mail in){
        mailDao.add(in);
    }
    public Mail findMailById(Integer id){
        return mailDao.findMailById(id);
    }
}
