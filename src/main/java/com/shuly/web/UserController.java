package com.shuly.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.shuly.service.KeyService;
import com.shuly.tool.other.JsonResult;
import com.shuly.tool.other.Md5;
import com.shuly.tool.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.shuly.dao.UserDao;
import  com.shuly.tool.pojo.User;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.shuly.tool.other.JacksonUtil;
import org.springframework.web.bind.annotation.SessionAttributes;
/**
 * Created by shuly on 16-3-20.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    KeyService keyService;
    @RequestMapping("/register")
    @ResponseBody
    public Object register(HttpServletRequest request,HttpSession session,
                   @RequestParam(value = "name",required=false)String name,
                   @RequestParam(value = "telnum",required=false)String telnum,
                   @RequestParam(value = "password",required=false)String password) {

        password= Md5.getMd5(password);
        User user = new User();
        user.setUsername(name);
        user.setPassword(password);
        user.setEmailr(name+"@shuly.com");
        user.setTelnum(telnum);
        user.setAdd("");
        user.setLevelr(1);
        user.setPoint(0);
        user.setUtype(0);
        user.setIscheck(0);
        user.setCreate_time(new Timestamp(System.currentTimeMillis()));
        user.setLast_visit_time(new Timestamp(System.currentTimeMillis()));
        user.setPic("/upload/head/default_head.jpg");
        if(keyService.isRegisterOk(user)) {
            keyService.register(user);
            session.setAttribute("curUser",user);
            System.out.println("asdasd??asd");
        }
        else {
            return JsonResult.error("这个用户名字或者电话号已经注册已经注册");
        }
        return JsonResult.ok("","/index.jsp");
    }
    @RequestMapping("/login")
    @ResponseBody
    public Object register(HttpServletRequest request,HttpSession session,
                                 @RequestParam(value = "name",required=false)String name,
                                 @RequestParam(value = "password",required=false)String password) {

        password = Md5.getMd5(password);
        User user =keyService.isLogin(name, password);
        if(user ==null){
            return JsonResult.error("用户名或密码不对奥");
        }
        else{
            session.setAttribute("curUser",user);
        }
        return JsonResult.ok("","/index.jsp");
    }

    @RequestMapping("/signout")
    @ResponseBody
    public Object  register(HttpServletRequest request,HttpSession session) {
        session.removeAttribute("curUser");
        return JsonResult.ok("","/index.jsp");
    }
    @RequestMapping("/curUser")
    @ResponseBody
    public Object curUser(HttpServletRequest request,HttpSession session){
        User curUser= new User();
        if(session.getAttribute("curUser")!=null){
            curUser=((User)session.getAttribute("curUser"));
            curUser.setPassword("null");
            System.out.println(curUser.getCreate_time());
        }
        else
            curUser.setId(-1);
        return JsonResult.ok(curUser);
    }
}
