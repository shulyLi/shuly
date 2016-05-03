package com.shuly.web;

import com.shuly.service.KeyService;
import com.shuly.tool.other.JsonResult;
import com.shuly.tool.other.KeyJudge;
import com.shuly.tool.other.Tool;
import com.shuly.tool.pojo.Deal;
import com.shuly.tool.pojo.Good;
import com.shuly.tool.pojo.Leave;
import com.shuly.tool.pojo.User;
import com.shuly.tool.table.DealTable;
import com.shuly.tool.table.LeaveTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuly on 16-4-23.
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {
    static int TYPE = 3;
    @Autowired
    KeyJudge keyJudge;
    @Autowired
    KeyService keyService;
    @RequestMapping(value = "/update.json")
    @ResponseBody
    public Object update(HttpServletRequest request ,HttpSession session,
                                  @RequestParam(value = "id",required=false)Integer id,
                                  @RequestParam(value = "msg",required=false)String msg,
                                  @RequestParam(value = "lever",required=false)Integer lever) {
        User user = (User)session.getAttribute("curUser");

        if(user==null){
            return JsonResult.error("没有登陆","/index.jsp");
        }
        Leave leave = keyService.findLeaveById(id);

        if(leave==null){
            return JsonResult.error("没有");
        }else if(leave.getFrom_user()!=user.getId()){
            return JsonResult.error("您无权去评价");
        }
        Good good = keyService.findGoodById(leave.getToId());
        if(good==null){
            return JsonResult.error("what？？？");
        }
        int point = lever-leave.getLever();
        good.setPoint(good.getPoint()+point);
        good.to();{
            if(leave.getLever()!=0){
                good.intJudge[leave.getLever()==-1?0:1]--;
            }
            if(lever!=0){
                good.intJudge[lever==-1?0:1]++;
            }
        }
        good.back();
        keyService.goodPoint(good.getPoint(),good.getId(),good.getJudge());
        keyService.userPoint(point,good.getUser_id());
        keyService.updateLeaver(id,lever,msg,new Timestamp(System.currentTimeMillis()));
        keyService.addOp(user.getId(),TYPE,leave.getToId(),"对商品"+leave.getToName()+"进行了评价",keyJudge.getIpAddr(request));
        return JsonResult.error("成功！");
    }


    @RequestMapping(value = "/getMyCanDo.json")
    @ResponseBody
    public Object getMyCanDo(HttpServletRequest request ,HttpSession session){
        User user = (User)session.getAttribute("curUser");
        if(user==null){
            return JsonResult.error("没有登陆","/index.jsp");
        }
        List<Leave> key = keyService.getLeaveByUserId(user.getId());
        List<LeaveTable> ans = new ArrayList<LeaveTable>();
        if(key!=null){
            for(Leave item : key){
                ans.add(item.toTable());
            }
        }
        return JsonResult.ok(ans);
    }
    @RequestMapping(value = "/getGoodMsg.json")
    @ResponseBody
    public Object changeDealState(HttpServletRequest request ,HttpSession session,
                                  @RequestParam(value = "goodId",required=true)Integer id){
        Good good = keyService.findGoodById(id);
        if(good==null){
            return JsonResult.error("有点问题啊。这个商品找不到了");
        }
        List<Leave> key = keyService.getleaveByGoodId(id);
        List<Map<String,Object>> ans = new ArrayList<Map<String, Object>>();
        if(key!=null){
            for(Leave item : key){
                Map<String,Object> it = new HashMap<String, Object>() ;
                it.put("left",item);
                it.put("user",keyService.getUserById(item.getFrom_user()));
                ans.add(it);
            }
        }
        return JsonResult.ok(ans);
    }
}
