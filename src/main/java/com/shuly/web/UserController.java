package com.shuly.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.shuly.service.KeyService;
import com.shuly.tool.other.JsonResult;
import com.shuly.tool.other.KeyJudge;
import com.shuly.tool.other.Md5;
import com.shuly.tool.pojo.Mail;
import com.shuly.tool.pojo.Op;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import  com.shuly.tool.pojo.User;
import java.io.IOException;
import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by shuly on 16-3-20.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    static int TYPE= 1;
    @Autowired
    KeyService keyService;
    @Autowired
    KeyJudge keyJudge;

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
            User key = keyService.findUserByName(name);
            if(key==null){
                return JsonResult.ok("sorry here is some wrong!");
            }
            session.setAttribute("curUser",key);
            keyService.addOp(key.getId(),TYPE,-1,"注册",keyJudge.getIpAddr(request));
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
            user.setPassword(null);
            session.setAttribute("curUser",user);
            keyService.addOp(user.getId(),TYPE,-1,"登陆",keyJudge.getIpAddr(request));
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
        }
        else
            curUser.setId(-1);
        Map<String,Object>  ans =new HashMap<String, Object>();
        ans.put("user",curUser);
        if(curUser.getId()!=-1){
            ans.put("mail", keyService.notReadMail(curUser.getId()));
            ans.put("needGrade", keyService.notGrade(curUser.getId()));
        }
        return JsonResult.ok(ans);
    }
    @RequestMapping("/toUser")
    @ResponseBody
    public Object toUser(HttpServletRequest request,HttpSession session){
        User curUser= new User();
        if(session.getAttribute("curUser")!=null){
            curUser=((User)session.getAttribute("curUser"));
            curUser.setPassword("null");
            return JsonResult.ok(curUser);
        }
        else
            return JsonResult.error("你没有登陆啊","/index.jsp");
    }

    @RequestMapping("/userInfoDeatail.json")
    @ResponseBody
    public Object detailInfo(HttpServletRequest request,HttpSession session,
                             @RequestParam(value = "id",required=false)Integer id){
        User curUser= new User();
        if(session.getAttribute("curUser")!=null){
            curUser=((User)session.getAttribute("curUser"));
            curUser.setPassword("null");
        }
        else
            return JsonResult.error("你没有登陆啊","/index.jsp");
        List<Op> tmp =null;
        if(id==null || (curUser.getLevelr()&8)!=0){
            id=curUser.getId();
            tmp = keyService.getOpByUserId(id);
        }
        else{
            tmp = keyService.getOpByUserIdLimit(id);
        }
        Map<String,Object> ans= new HashMap<String, Object>();
        User key = keyService.getUserById(id);
        ans.put("user",key);
        ans.put("op",tmp);
        return JsonResult.ok(ans);
    }
    @RequestMapping("/userSetting.json")
    @ResponseBody
    public Object userSetting(HttpServletRequest request,HttpSession session,
                              @RequestParam(value = "tel",required=true)String tel,
                              @RequestParam(value = "add",required=true)String add){
        User curUser= new User();
        if(session.getAttribute("curUser")!=null){
            curUser=((User)session.getAttribute("curUser"));
            curUser.setPassword("null");
        }
        else
            return JsonResult.error("你没有登陆啊","/index.jsp");
        keyService.addOp(curUser.getId(),TYPE,-1,"更新了自己的一些资料",keyJudge.getIpAddr(request));
        return null;
    }
    @RequestMapping("/toBeMan")
    @ResponseBody
    public Object toBeMan(HttpServletRequest request, HttpSession session,
                                @RequestParam(value = "Mantel",required=true)String tel,
                                @RequestParam(value = "Manname",required=true)String name,
                                @RequestParam(value = "Manlocal",required=true)String local,
                                @RequestParam(value = "Mandata",required=true) MultipartFile myfile)throws IOException{

        User curUser= new User();
        if(session.getAttribute("curUser")!=null){
            curUser=((User)session.getAttribute("curUser"));
            curUser.setPassword("null");
        }
        else
            return JsonResult.error("您似乎没有登陆","/index.jsp");
        String wolegequ="";
        User user = keyService.getUserById(curUser.getId());
        if((user.getLevelr()&2)!=0){
            return JsonResult.error("您似乎已经是商人了");
        }
        if(myfile.isEmpty()){
            System.out.println("文件未上传");
        }else{
            System.out.println("文件长度: " + myfile.getSize());
            System.out.println("文件类型: " + myfile.getContentType());
            System.out.println("文件名称: " + myfile.getName());
            System.out.println("文件原名: " + myfile.getOriginalFilename());
            System.out.println("========================================");
            String realPath = request.getSession().getServletContext().getRealPath("/upload/MasterCanSee");
            String realName=user.getUsername()+((new Date()).getTime())+myfile.getOriginalFilename();
            wolegequ= realPath+'/'+realName;
            FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, realName));
        }
        Mail keyMail = new Mail();
        keyMail.setHead("(id="+user.getId()+")申请成为商人申请");
        keyMail.setMes("{'name':'"+name+ "','tel':'"+tel+"','local':'"+local+"'}");
        keyMail.setMailtype(5);
        keyMail.setOwner_id(3);
        keyMail.setTo_user("admin");
        keyMail.setFilerar(wolegequ);
        keyMail.setFrom_user(user.getUsername());
        keyService.addMail(keyMail);
        keyMail.setMailtype(2);
        keyMail.setOwner_id(user.getId());
        keyService.addMail(keyMail);
        keyService.addOp(user.getId(),TYPE,-1,"申请成为商人",keyJudge.getIpAddr(request));
        return JsonResult.error("完事我们会尽快的回复您请注意您的邮件");
    }
    @RequestMapping("/canBeMan.json")
    @ResponseBody
    public  Object canBeMan(HttpServletRequest request, HttpSession session,
                            @RequestParam(value = "id",required=true)Integer id,
                            @RequestParam(value = "mailId",required=true)Integer mailId,
                            @RequestParam(value = "name",required=true)String name,
                            @RequestParam(value = "tel",required=true)String tel,
                            @RequestParam(value = "add",required=true)String add,
                            @RequestParam(value = "BOOL",required=true)Integer FLAG){
        User curUser= new User();
        if(session.getAttribute("curUser")!=null){
            curUser=((User)session.getAttribute("curUser"));
            curUser.setPassword("null");
        }
        else
            return JsonResult.error("您似乎没有登陆","/index.jsp");
        User user = keyService.getUserById(curUser.getId());

        if((user.getLevelr()&8)==0) return JsonResult.error("您没有权限");
        User to = keyService.getUserById(id);
        if(to==null) return JsonResult.error("诶有这个人");
        Mail keyMail = new Mail();
        keyMail.setHead("对你的商人申请进行回复");
        keyMail.setMailtype(2);
        keyMail.setOwner_id(3);
        keyMail.setTo_user(to.getUsername());
        keyMail.setFrom_user(user.getUsername());

        if(FLAG==1){
            keyService.updateUserBeMan(id,name,tel,add);
            keyMail.setMes("成功");
        }
        else{
            keyMail.setMes("失败具体信息可咨询admin");
        }
        keyService.addMail(keyMail);
        keyMail.setMailtype(1);
        keyMail.setOwner_id(to.getId());
        keyService.addMail(keyMail);
        keyService.mailIsReadByID(mailId);
        keyService.addOp(user.getId(),TYPE,to.getId(),"对"+to.getUsername()+"进行了审核结果是"+String.valueOf(FLAG),keyJudge.getIpAddr(request));
        return JsonResult.error("操作成功");
    }

}
