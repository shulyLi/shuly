package com.shuly.web;


import javax.servlet.http.HttpServletRequest;

import com.shuly.tool.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.shuly.dao.GoodsDao;
import sun.font.TrueTypeFont;

import java.util.List;

/**
 * Created by shuly on 15-12-31.
 */
@Controller
public class testController {

    @Autowired
    GoodsDao goodsDao;

    @RequestMapping(value = "/showGood.html")
    public String showGood(HttpServletRequest request ,
                           @RequestParam(value = "pageNum",required=true)Integer pageNum) {
        System.out.println(pageNum);
        List<Good> ans = goodsDao.getAll();
        for(Good tmp :ans){
            System.out.println(tmp);
        }
        Good key = goodsDao.findById(1);
        System.out.println(key);
        return "no";
    }
}
