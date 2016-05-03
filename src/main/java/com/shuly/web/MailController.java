package com.shuly.web;

import com.shuly.service.KeyService;
import com.shuly.tool.other.JsonResult;
import com.shuly.tool.other.KeyJudge;
import com.shuly.tool.pojo.Good;
import com.shuly.tool.pojo.Mail;
import com.shuly.tool.pojo.User;
import com.shuly.tool.table.MailTable;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by shuly on 15-12-31.
 *
 */
@Controller
@RequestMapping("/mail")
public class MailController {
    static int TYPE=5;
    @Autowired
    KeyJudge keyJudge;
    @Autowired
    KeyService keyService;
    @RequestMapping(value ="/add.json")
    @ResponseBody
    public Object addMail(HttpServletRequest request ,HttpSession session,
                          @RequestParam(value = "type",required=true)Integer type,
                          @RequestParam(value = "msg",required=true)String msg,
                          @RequestParam(value = "sub",required=true)String sub,
                          @RequestParam(value = "to",required=true)String to){
        User user = null;
        if(session.getAttribute("curUser")!=null){
            user=(User)session.getAttribute("curUser");
        }
        else{
            return JsonResult.error("没有登陆");
        }
        User To = keyService.findUserByName(to);
        if(null == To){
            return JsonResult.error("没有这个用户");
        }
        if(To.getId()==user.getId()){
            return JsonResult.error("给自己发？ 城会玩！");
        }
        Mail in = new Mail();
        in.setOwner_id(user.getId());
        in.setFrom_user(user.getUsername());
        in.setTo_user(to);
        in.setHead(sub);
        in.setMes(msg);
        in.setMailtype(type);
        keyService.addMail(in);
        if(type==2){
            in.setOwner_id(To.getId());
            in.setMailtype(1);
            keyService.addMail(in);
        }
        keyService.addOp(user.getId(),TYPE,-1,"发了封邮件给"+to,keyJudge.getIpAddr(request));
        return JsonResult.error("成功");
    }
    @RequestMapping(value = "/find.json")
    @ResponseBody
    public Object findMail(HttpServletRequest request ,HttpSession session,
                           @RequestParam(value = "type",required=true)Integer type){
        User user = null;
        if(session.getAttribute("curUser")!=null){
            user=(User)session.getAttribute("curUser");
        }
        else{
            return JsonResult.error("没有登陆");
        }
        List<Mail> key =null;
        key = keyService.findMailByTypeOwner(type,user.getId());
        List<MailTable> ans = new ArrayList<MailTable>();
        for (Mail item:key){
            ans.add(item.toMailTable());
        }
        int[] num = keyService.countNotReadMail(user.getId());
        return JsonResult.mailOk(ans,num);
    }
    @RequestMapping(value = "/getMail.json")
    @ResponseBody
    public Object getMail(HttpServletRequest request ,HttpSession session,
                            @RequestParam(value = "id",required=true)Integer id) {
        User user = null;
        if(session.getAttribute("curUser")!=null){
            user=(User)session.getAttribute("curUser");
        }
        else{
            return JsonResult.error("没有登陆");
        }
        Mail out = keyService.findMailById(id);
        if(out==null){
            return JsonResult.error("没有找到该信息");
        }
        if(user.getId()!=out.getOwner_id()){
            return JsonResult.error("该信息不属于你");
        }
        if(out.getMailtype()<5) {
            keyService.mailIsReadByID(out.getId());
        }
        if(out.getIsread()==0)
            keyService.addOp(user.getId(),TYPE,id,"阅读了"+out.getHead(),keyJudge.getIpAddr(request));
        return JsonResult.ok(out);
    }
    private String ramdomName(String head){
        String ans = head;
        Date tmp = new Date();
        ans = tmp.getTime()+getRandomString(5)+head;
        return new String(ans);
    }
    public static String getRandomString(int length) {
        final  String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
