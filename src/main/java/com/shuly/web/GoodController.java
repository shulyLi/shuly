package com.shuly.web;
import java.io.File;
import java.sql.Timestamp;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shuly.service.KeyService;
import com.shuly.tool.other.JsonResult;
import com.shuly.tool.other.KeyJudge;
import com.shuly.tool.pojo.Good;
import com.shuly.tool.pojo.User;
import com.shuly.tool.table.ManagerGoodTable;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by shuly on 15-12-31.
 *
 */
@Controller
@RequestMapping("/good")
public class GoodController {
    static int TYPE= 2;
    @Autowired
    KeyJudge keyJudge;
    @Autowired
    KeyService keyService;
    @RequestMapping(value ="/find.json")
    @ResponseBody
    public Object findGood(HttpServletRequest request ,HttpSession session,
                           @RequestParam(value = "pageNum",required=false)Integer pageNum,
                           @RequestParam(value = "province",required=false)String[] province,
                           @RequestParam(value = "findData",required=false)String findData){
        if(pageNum==null) return "fuck what are you doing!";
        if(province != null && province.length>0){
            for(int i=0;i < province.length;i++){
                if(keyJudge.isProvinceOk(province[i]))continue;
                return "fuck what are you doing?";
            }
        }
        else {province = new String[0];}
        return keyService.findGood(province,findData,pageNum);
    }

    @RequestMapping("/showGoodDetail")
    @ResponseBody
    public Object benefitFileList(HttpServletRequest request,HttpSession session,
                                  @RequestParam(value = "goodId", required = false) Integer id) throws Exception {
        String IP = keyJudge.getIpAddr(request);
        if(IP==null) IP = new String("NULL");
        User user = null;
        if(session.getAttribute("curUser")!=null){
            user=(User)session.getAttribute("curUser");
        }
        System.out.println(id);
        Object ans = keyService.findGoodDetail(id);
        return JsonResult.ok(ans);
    }

    @RequestMapping("/showGood.json")
    @ResponseBody
    public Object showGood(HttpServletRequest request,HttpSession session,
                                  @RequestParam(value = "goodId", required = true) Integer id) throws Exception {
        String IP = keyJudge.getIpAddr(request);
        if(IP==null) IP = new String("NULL");
        User user = null;
        if(session.getAttribute("curUser")!=null){
            user=(User)session.getAttribute("curUser");
        }
        Good ans = keyService.findGoodById(id);
        ans.toState();
        return JsonResult.ok(ans);
    }
    @RequestMapping("/updateGood.json")
    @ResponseBody
    public Object updateGood(HttpServletRequest request,HttpSession session,
                            @RequestParam(value = "goodId", required = true) Integer id,
                            @RequestParam(value = "price", required = true) double price,
                            @RequestParam(value = "number", required = true) Integer number,
                            @RequestParam(value = "isshelf", required = true) Integer isshelf) throws Exception {
        User user = null;
        String IP = keyJudge.getIpAddr(request);
        if(IP==null) IP = new String("NULL");
        if(session.getAttribute("curUser")!=null){
            user=(User)session.getAttribute("curUser");
        }
        else{
            return JsonResult.error("没有登陆","/index.jsp");
        }

        Good tmp =keyService.findGoodById(id);
        if(tmp.getUser_id()!=user.getId() && (user.getLevelr()&8)==0  ){
            return JsonResult.error("您没有这个权限","/index.jsp");
        }
        if(tmp==null){
            return JsonResult.error("没有这个商品");
        }
        String msg = keyService.updateGood(id,price,number,isshelf);
        keyService.addOp(user.getId(),2,id,"更新商品"+tmp.getId()+"的信息",keyJudge.getIpAddr(request));
        return JsonResult.error("完成");
    }
    @RequestMapping("/opGood.json")
    @ResponseBody
    public Object opGood(HttpServletRequest request,HttpSession session,
                             @RequestParam(value = "goodId", required = true) Integer id,
                             @RequestParam(value = "ischeck", required = true) Integer ischeck) throws Exception {
        User user = null;
        String IP = keyJudge.getIpAddr(request);
        if(IP==null) IP = new String("NULL");
        if(session.getAttribute("curUser")!=null){
            user=(User)session.getAttribute("curUser");
        }
        else{
            return JsonResult.error("没有登陆","/index.jsp");
        }
        if((user.getLevelr()&8)==0){
            return JsonResult.error("对不起你没有这个权限","/index.jsp");
        }
        Good tmp =keyService.findGoodById(id);
        if(tmp==null){
            return JsonResult.error("没有这个商品");
        }
        String msg = keyService.opGoodCheck(id,ischeck);
        keyService.addOp(user.getId(),TYPE,id,"审核商品"+tmp.getGoodname(),keyJudge.getIpAddr(request));
        return   JsonResult.error("OK");
    }
    @RequestMapping("/add")
    public ModelAndView addGood(HttpServletRequest request,HttpSession session,
                                @RequestParam(value = "pic",required=false) MultipartFile myfile,
                                @RequestParam(value = "name",required=false) String name,
                                @RequestParam(value = "s_province",required=false) String s_province,
                                @RequestParam(value = "s_city",required=false) String s_city,
                                @RequestParam(value = "s_county",required=false) String s_county,
                                @RequestParam(value = "shortMes",required=false) String shortMes,
                                @RequestParam(value = "describe",required=false) String describle
                                ) throws IOException{
        User user = null;
        ModelAndView ans =new ModelAndView();
        if(session.getAttribute("curUser")!=null){
            user=(User)session.getAttribute("curUser");
        }
        else{
            ans.setViewName("login");
            ans.addObject("info","您好像没有登陆");
            return ans;
        }
        if((user.getLevelr()&2)==0){
            return null;
        }
        if(myfile.isEmpty()){
            System.out.println("文件未上传");
        }else{
            System.out.println("货物名字: " + name);
            System.out.println("货物描述: " + describle);
            System.out.println("文件长度: " + myfile.getSize());
            System.out.println("文件类型: " + myfile.getContentType());
            System.out.println("文件名称: " + myfile.getName());
            System.out.println("文件原名: " + myfile.getOriginalFilename());
            System.out.println("========================================");
            String realPath = request.getSession().getServletContext().getRealPath("/upload/pic");
            String realName=String.valueOf(user.getId())+ramdomName(myfile.getOriginalFilename());
            FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, realName));

            ans.setViewName("success");
            Good tmp =new Good();
            tmp.setPic_url("/upload/pic/"+realName);
            tmp.setTag(shortMes);
            tmp.setIsshelf(0);
            tmp.setProvince(s_province);
            tmp.setDetailPlace(s_city+','+s_county);
            tmp.setJudge("0|0|0|0|0");
            tmp.setGoodname(name);
            tmp.setMes(describle);
            tmp.setUser_id(user.getId());
            tmp.setCreate_time(new Timestamp(System.currentTimeMillis()));
            String msg =keyService.addGood(tmp);
            keyService.addOp(user.getId(),TYPE,-1,"添加商品"+name,keyJudge.getIpAddr(request));
        }
        return ans;
    }
    @RequestMapping("/myGood.json")
    @ResponseBody
    public Object getMyGood(HttpServletRequest request,HttpSession session,
                            @RequestParam(value = "goodid",required=false)Integer goodId) {
        User user = null;
        if(session.getAttribute("curUser")!=null){
            user=(User)session.getAttribute("curUser");
        }
        else{
            //return JsonResult.ok("");
            return JsonResult.error("没有登陆","/index.jsp");
        }
        if((user.getLevelr()&2)==0){
            return JsonResult.error("您没有这个权限","/index.jsp");
        }
        if(goodId==null){
            List<ManagerGoodTable> ans =new ArrayList<ManagerGoodTable>();
            List<Good> tmp = keyService.findGoodByUser(user.getId());
            if(tmp!=null)
                for(Good item : tmp){
                    ans.add(item.toGoodTable());
                }
            return JsonResult.ok(ans);
        }
        else{
            Good tmp=keyService.findGoodById(goodId);
            if(tmp==null){
                return JsonResult.error("没有这个物品啊","/index.jsp");
            }
            return JsonResult.ok(tmp.toGoodTable());
        }
    }
    @RequestMapping("/allGood.json")
    @ResponseBody
    public Object getMyGood(HttpServletRequest request,HttpSession session) {
        User user = null;
        if(session.getAttribute("curUser")!=null){
            user=(User)session.getAttribute("curUser");
        }
        else{
            //return JsonResult.ok("");
            return JsonResult.error("没有登陆","/index.jsp");
        }
        if((user.getLevelr()&8)==0){
            return JsonResult.error("你没有权限","/index.jsp");
        }
        List<ManagerGoodTable> ans =new ArrayList<ManagerGoodTable>();
        List<Good> tmp = keyService.findAllGood();
        if(tmp!=null)
            for(Good item : tmp){
                ans.add(item.toGoodTable());
            }
        return JsonResult.ok(ans);
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
