package com.shuly.service;

import com.shuly.dao.*;
import com.shuly.tool.other.Tool;
import com.shuly.tool.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuly on 16-3-22.
 */
@Service
public class KeyService {
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    UserDao userDao;
    @Autowired
    VisiteDao visiteDao;
    @Autowired
    MailDao mailDao;
    @Autowired
    DealDao dealDao;
    @Autowired
    OpDao opDao;
    @Autowired
    LeaveDao leaveDao;
    public boolean isRegisterOk(User user) {
        return userDao.getMatchCountForRegister(user.getTelnum(), user.getUsername()) == 0;
    }

    public void register(User user) {
        userDao.addUser(user);
    }

    public User isLogin(String name, String password) {
        return userDao.getForLogin(name, password);
    }

    public void updateUser(User user) {

    }
    public void userPoint(Integer point,Integer id){
        userDao.point(point,id);
    }
    public void updateUserBeMan(Integer id,String name,String tel,String add){
        userDao.updateBeMan(id,name,tel,add);
    }
    public User findUserByName(String name) {
        return userDao.getByName(name);
    }
    public User getUserById(Integer id){
        return userDao.getById(id);
    }
    /* good*/
    public String addGood(Good good) {
        goodsDao.add(good);
        return "添加商品成功";
    }
    public void goodPoint(Integer point,Integer id,String judge){
        goodsDao.point(point,judge,id);
    }
    public Good findGoodById(Integer goodId) {
        return goodsDao.findById(goodId);
    }
    public Map<String, Object> findGoodDetail(Integer goodId) {
        Good good = goodsDao.findById(goodId);
        User user = userDao.getById(good.getUser_id());
        Map<String, Object> hash = new HashMap();
        hash.put("owner", user);
        hash.put("good", good);
        return hash;
    }

    public List<Good> findAllGood() {
        return goodsDao.getAll();
    }

    public List<Good> findGood(String[] province, String findData, Integer pageNum) {
        return goodsDao.findGood(province, findData, pageNum);
    }

    public List<Good> findGoodByUser(int id) {
        return goodsDao.findByUserId(id);
    }

    public String opGoodCheck(Integer goodId, Integer ischeck) {
        goodsDao.updateIscheck(goodId, ischeck);
        return "管理员设置ischeck is" + String.valueOf(ischeck);
    }

    public String updateGood(Integer id, double price, Integer number, Integer isshelf) {
        goodsDao.updateSome(id, price, number, isshelf);
        return "更新物品的可变参数";
    }
    /*
    public List<Good>  getGoods(){

    }
    */

    /*mail*/
    public List<Mail> findMailByTypeOwner(Integer type, int id) {
        return mailDao.findMailByTypeOwner(id, type);
    }

    public int[] countNotReadMail(int id) {
        int[] ans = new int[4];
        ans[0] = mailDao.countNotReadMail(id, 1);
        ans[1] = mailDao.countNotReadMail(id, 5);
        ans[2] = mailDao.countNotReadMail(id, 6);
        return ans;
    }

    public String addMail(Mail in) {
        mailDao.add(in);
        return "发送邮件";
    }

    public Mail findMailById(Integer id) {
        Mail ans =mailDao.findMailById(id);
        return ans;
    }
    public void  mailIsReadByID(Integer id) {
        Mail ans =mailDao.findMailById(id);
        if(ans!=null&&ans.getIsread()==0)
            mailDao.isRead(id);
    }
    /*deal*/
    public String addDeal(Deal in) {
        dealDao.insert(in);
        return "添加订单";
    }
    public List<Deal> allDeal(){
        return dealDao.all();
    }
    public Deal getDealById(Integer Id) {
        return dealDao.getById(Id);
    }

    public List<Deal> toMyDeal(Integer id) {
        return dealDao.getToMyDeal(id);
    }

    public List<Deal> fromMyDeal(Integer id) {
        return dealDao.getFromMyDeal(id);
    }

    public String dealUpdate(Integer id,Integer type) {
        dealDao.updateState(id, type);
        return "更新商品的上下架状订单状态"+String.valueOf(type);
    }

    public Map<String, Object> getDealDetailById(Integer id) {
        System.out.println(2);
        Deal deal = dealDao.getById(id);
        Good good = goodsDao.findById(deal.getGood_id());
        User from = userDao.getById(deal.getOwner_id());
        User to = userDao.getById(deal.getUser_id());
        Map<String, Object> hash = new HashMap();
        if (good == null || from == null || to == null) {
            hash.put("msg", "订单数据异常");
        }
        hash.put("good", good);
        hash.put("from", from);
        hash.put("to", to);
        hash.put("deal", deal);
        hash.put("states", Tool.dealState[deal.getStates()]);
        return hash;
    }

    /*op*/
    public void addOp(Integer who,Integer type,Integer to,String msg,String IP) {
        Op tmp = new Op();
        tmp.setUser_id(who);
        tmp.setType(type);
        tmp.setTo_id(to);
        tmp.setReason(msg);
        tmp.setCreate_time(new Timestamp(System.currentTimeMillis()));
        tmp.setIp(IP);
        opDao.insert(tmp);
    }
    public List<Op> getOpByUserId(Integer id){
        return opDao.getByUserId(id);
    }
    public List<Op> getOpByUserIdLimit(Integer id){
        return opDao.getByUserIdLimit(id);
    }



    /*leaver*/
    public void addLeave(Leave leave){
        leaveDao.add(leave);
    }
    public void updateLeaver(Integer id,Integer l,String msg,Timestamp c_time){
        leaveDao.update(id,l,msg,c_time);
    }
    public Leave findLeaveById(Integer id){
        return leaveDao.findById(id);
    }
    public List<Leave> getleaveByGoodId(Integer id){
        return leaveDao.getByGoodId(id);
    }
    public List<Leave> getLeaveByUserId(Integer id){
        return leaveDao.getByUserId(id);
    }

    public Integer notReadMail(Integer id){
        return mailDao.notRead(id);
    }
    public Integer notGrade(Integer id){
        return leaveDao.notGrade(id);
    }
}
