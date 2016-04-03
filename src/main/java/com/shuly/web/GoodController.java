package com.shuly.web;
import java.io.File;
import java.sql.Timestamp;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shuly.service.KeyService;
import com.shuly.tool.pojo.Good;
import com.shuly.tool.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.FileUtils;
import org.springframework.web.servlet.ModelAndView;
import com.shuly.dao.GoodsDao;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by shuly on 15-12-31.
 *
 */
@Controller
@RequestMapping("/good")
public class GoodController {


    @Autowired
    KeyService keyService;
    @Autowired
    GoodsDao goodsDao;
    @RequestMapping(value = "/show.json")
    @ResponseBody
    public Object showGood(HttpServletRequest request ,HttpSession session,
                           @RequestParam(value = "pageNum",required=false)Integer pageNum) {
        //System.out.println(pageNum);
        Map<String, Object> out = new HashMap<String, Object>();
        List<Good> ans = goodsDao.getAll();
        return ans;
    }
    @RequestMapping("/showGoodDetail")
    @ResponseBody
    public Object benefitFileList(@RequestParam(value = "goodId", required = false) Integer id) throws Exception {
        //Map<String, Object> out = new HashMap<String, Object>();
        System.out.println("id:"+id);
        Good ans = goodsDao.findById(id);
        return ans;
    }
    @RequestMapping("/add")
    public ModelAndView addGood(HttpServletRequest request,HttpSession session,
                                @RequestParam(value = "pic",required=false) MultipartFile myfile,
                                @RequestParam(value = "name",required=false) String name,
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

            tmp.setGoodname(name);
            tmp.setMes(describle);
            tmp.setUser_id(user.getId());
            tmp.setUser_telnum(user.getTelnum());
            tmp.setCreate_time(new Timestamp(System.currentTimeMillis()));
            keyService.changeGood(tmp);
        }
        return ans;
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
