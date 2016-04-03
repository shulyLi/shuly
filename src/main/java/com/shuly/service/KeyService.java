package com.shuly.service;

import com.shuly.dao.GoodsDao;
import com.shuly.dao.UserDao;
import com.shuly.tool.pojo.Good;
import com.shuly.tool.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean isRegisterOk(User user){
        return userDao.getMatchCountForRegister(user.getEmailr())==0;
    }
    public void register(User user){
        userDao.addUser(user);
    }
    public boolean isLoginOk(String email,String password){
        return userDao.getMatchCountForLogin(email,password)>0;
    }
    public User getUserByEmail(String email){
        return userDao.getUserByEmail(email);
    }
    public void updateUser(User user){

    }
    public void changeGood(Good tmp){
        if(tmp.getId()==-1){
            goodsDao.add(tmp);
        }
        else{
            goodsDao.update(tmp);
        }
    }
    /*
    public List<Good>  getGoods(){

    }
    */


}
