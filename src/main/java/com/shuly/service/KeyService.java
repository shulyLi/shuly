package com.shuly.service;

import com.shuly.dao.GoodsDao;
import com.shuly.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by shuly on 16-3-22.
 */
public class KeyService {
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    UserDao userDao;


}
