package com.shuly.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.shuly.service.KeyService;
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

@SessionAttributes("curUser")
public class UserController {
    @Autowired
    KeyService keyService;
    @RequestMapping("/register")
    public ModelAndView register(HttpServletRequest request ,
                   @RequestParam(value = "name",required=false)String name,
                   @RequestParam(value = "email",required=false)String email,
                   @RequestParam(value = "password",required=false)String password) {
        User user = new User();
        user.setUsername(name);
        user.setEmailr(email);
        user.setPassword(password);
        ModelAndView out = new ModelAndView();
        try {
            if(keyService.isRegisterOk(user)) {
                keyService.register(user);
                out.setViewName("success");
            }
            else {
                out.setViewName("error");
                out.addObject("info","该邮箱已经被注册");
            }
            return out;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            out.addObject("info",e.getCause());
            out.setViewName("error");
            return out;
        }
        finally {
            //
        }
    }
    @RequestMapping("/login")
    public ModelAndView register(HttpServletRequest request,HttpSession session,
                                 @RequestParam(value = "email",required=false)String email,
                                 @RequestParam(value = "password",required=false)String password) {
        User user = new User();
        user.setEmailr(email);
        user.setPassword(password);
        ModelAndView out = new ModelAndView();
        try {
            if(keyService.isLoginOk(email,password)) {
                out.setViewName("success");
                session.setAttribute("curUser",keyService.getUserByEmail(email));
            }
            else {
                out.setViewName("error");
                out.addObject("info","帐号或者密码不对");
            }
            return out;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            out.addObject("info",e.getMessage());
            out.setViewName("error");
            return out;
        }
        finally {
            //
        }
    }
}
