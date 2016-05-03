package com.shuly.web;
import java.io.File;
import java.sql.Timestamp;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.shuly.service.KeyService;
import com.shuly.tool.other.JsonResult;
import com.shuly.tool.other.KeyJudge;
import com.shuly.tool.other.Tool;
import com.shuly.tool.pojo.Deal;
import com.shuly.tool.pojo.Good;
import com.shuly.tool.pojo.Leave;
import com.shuly.tool.pojo.User;
import com.shuly.tool.table.DealTable;
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
 * Created by shuly on 16-4-23.
 */
@Controller
@RequestMapping("/deal")
public class dealController {
    static int TYPE=4;
    @Autowired
    KeyJudge keyJudge;
    @Autowired
    KeyService keyService;

    @RequestMapping(value = "/add.json")
    @ResponseBody
    public Object initDeal(HttpServletRequest request ,HttpSession session,
                           @RequestParam(value = "province",required=false) String province,
                           @RequestParam(value = "city",required=false) String city,
                           @RequestParam(value = "county",required=false) String county,
                           @RequestParam(value = "goodId",required=false) Integer goodId,
                           @RequestParam(value = "goodNum",required=false)Integer num,
                           @RequestParam(value = "detailAdd",required=false)String add,
                           @RequestParam(value = "buyName",required=false)String buyName,
                           @RequestParam(value = "buyPhone",required=false)String buyPhone){
        String place = province+','+city+','+county;
        Good good = keyService.findGoodById(goodId);
        User user = (User)session.getAttribute("curUser");
        if(user==null){
            return JsonResult.error("没有登陆","/index.jsp");
        }
        if(good==null){
            return JsonResult.error("没有该物品","/index.jsp");
        }

        Deal in = new Deal();
        in.setAdd(place);
        in.setGood_id(goodId);
        in.setOwner_id(good.getUser_id());
        in.setUser_id(user.getId());
        in.setNum(num);
        in.setDetailAdd(add);
        in.setGoodPrice(num*good.getPrice());
        in.setTradePrice(0.6*num);
        in.setBuyName(buyName);
        in.setBuyPhone(buyPhone);
        in.setStates(0);
        in.setIsMes(0);
        in.setCreate_time(new Timestamp(System.currentTimeMillis()));
        String msg=keyService.addDeal(in);

        keyService.addOp(user.getId(),TYPE,-1,"对物品"+good.getGoodname()+"发起协议",keyJudge.getIpAddr(request));

        return JsonResult.error("成功！");
    }
    @RequestMapping(value = "/fromMyDeal.json")
    @ResponseBody
    public Object fromMyDeal(HttpServletRequest request ,HttpSession session){
        User user = (User)session.getAttribute("curUser");
        if(user==null){
                return JsonResult.error("没有登陆","/index.jsp");
        }
        List<Deal>key = keyService.fromMyDeal(user.getId());
        if(key==null){
            return JsonResult.ok("");
        }
        List<DealTable> ans = new ArrayList<DealTable>();
        for(Deal item :key){
            ans.add(Tool.getDealTable(keyService.findGoodById(item.getGood_id()), item));
        }

        return JsonResult.ok(ans);
    }

    @RequestMapping(value = "/toMyDeal.json")
    @ResponseBody
    public Object toMyDeal(HttpServletRequest request ,HttpSession session){
        User user = (User)session.getAttribute("curUser");
        if(user==null){
            return JsonResult.error("没有登陆","/index.jsp");
        }
        List<Deal>key = keyService.toMyDeal(user.getId());
        List<DealTable> ans = new ArrayList<DealTable>();
        Good tmp = null;
        if(key==null){
            return JsonResult.ok("");
        }
        for(Deal item :key){
            ans.add(Tool.getDealTable(keyService.findGoodById(item.getGood_id()), item));
        }
        return JsonResult.ok(ans);
    }
    @RequestMapping(value = "/showDealDetail.json")
    @ResponseBody
    public Object showDealDetail(HttpServletRequest request ,HttpSession session,
                                 @RequestParam(value = "dealId",required=false)Integer id){
        User user = (User)session.getAttribute("curUser");
        if(user==null){
            return JsonResult.error("没有登陆","/index.jsp");
        }
        Map<String ,Object> ans = keyService.getDealDetailById(id);
        if(ans.containsKey("msg")){
            return JsonResult.error((String)ans.get("msg"));
        }
        if( user.getId() != ((User)ans.get("from")).getId() && (user.getId() != ((User)ans.get("to")).getId() )&& (user.getLevelr()&8)!=0){
            return JsonResult.error("您没有这个权利去查看");
        }
        return JsonResult.ok(ans);
    }
    @RequestMapping(value = "/changeDealState.json")
    @ResponseBody
    public Object changeDealState(HttpServletRequest request ,HttpSession session,
                                 @RequestParam(value = "id",required=false)Integer id,
                                 @RequestParam(value = "type",required=false)String type,
                                 @RequestParam(value = "key",required=false)Integer key){
        String IP = keyJudge.getIpAddr(request);
        User user = (User)session.getAttribute("curUser");

        if(user==null){
            return JsonResult.error("没有登陆","/index.jsp");
        }
        Deal deal = keyService.getDealById(id);

        if(deal==null){
            return JsonResult.error("呵呵嗒","/index.jsp");
        }
        if((user.getLevelr()&8)!=0 && (user.getId()!=deal.getUser_id()) && (user.getId()!=deal.getOwner_id())){
            return JsonResult.error("你没有对应的权限","/index.jsp");
        }
        Good good = keyService.findGoodById(deal.getGood_id());
        if(type=="from"){
            //some dif
        }
        String msg = keyService.dealUpdate(id,key);
        if(key==4){
            Leave  leave = new Leave();
            leave.setFrom_user(deal.getUser_id());
            leave.setToName(good.getGoodname());
            leave.setToId(deal.getGood_id());
            leave.setIsRight(0);
            leave.setLever(0);
            leave.setMes("");
            leave.setCreate_time(new Timestamp(System.currentTimeMillis()));
            keyService.addLeave(leave);
        }
        keyService.addOp(user.getId(),TYPE,id,"更新了协议"+id+"的状态",keyJudge.getIpAddr(request));
        return JsonResult.error("提交成功");
    }
    @RequestMapping(value = "/allDeal.json")
    @ResponseBody
    public Object allDeal(HttpServletRequest request ,HttpSession session){
        User user = (User)session.getAttribute("curUser");
        if(user==null){
            return JsonResult.error("没有登陆","/index.jsp");
        }
        if((user.getLevelr()&8)==0){
            return JsonResult.error("您没有这个权限");
        }
        List<Deal>key = keyService.allDeal();
        List<DealTable> ans = new ArrayList<DealTable>();
        Good tmp = null;
        if(key==null){
            return JsonResult.ok("");
        }
        for(Deal item :key){
            ans.add(Tool.getDealTable(keyService.findGoodById(item.getGood_id()), item));
        }
        return JsonResult.ok(ans);
    }
}
