package com.shuly.web;
import javax.servlet.http.HttpServletRequest;
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
/**
 * Created by shuly on 16-3-20.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserDao userDao;
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
            userDao.addUser(user);
            out.setViewName("success");
            return out;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            out.addObject("error",e.getCause());
            out.setViewName("error");
            return out;
        }
        finally {
            //
        }
    }
    @RequestMapping("/login")
    public ModelAndView register(HttpServletRequest request ,
                                 @RequestParam(value = "email",required=false)String email,
                                 @RequestParam(value = "password",required=false)String password) {
        ModelAndView out = new ModelAndView();
        try {
            int tmp = userDao.getMatchCount(email, password);
            System.out.println(tmp);
            out.setViewName("success");
            return out;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            out.addObject("error",e.getMessage());
            out.setViewName("error");
            return out;
        }
        finally {
            //
        }
    }
}
