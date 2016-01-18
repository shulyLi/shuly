package com.shuly.web;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * Created by shuly on 15-12-31.
 */
@Controller
public class testController {

    @RequestMapping(value = "/nihao.html")
    public ModelAndView loginCheck(HttpServletRequest request) {
        System.out.println("nihao");
        return new ModelAndView("main");
    }

}
