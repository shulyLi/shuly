package com.shuly.tool.pojo;
import com.shuly.tool.table.ManagerGoodTable;

import java.sql.Array;
import java.sql.Timestamp;
import java.util.Arrays;

/**
 * Created by shuly on 16-3-1.
 */
public class Good {
    int id;
    String goodname;
    int user_id;
    String pic_url;
    String detailPlace;
    String mes;
    String judge;
    int point;
    int ischeck;
    Timestamp create_time;
    String tag;
    String province;
    public Integer[] intJudge ;
    int isshelf;
    double price;
    int number;
    int tradenum;
    String tmp;
    public void to(){
        String []tmp=judge.trim().split("\\|");
        for(int i=0;i<tmp.length;++i){
            intJudge[i]=Integer.valueOf(tmp[i]);
        }
    }
    public void back(){
        StringBuilder tmp = new StringBuilder();
        for(int i=0;i<intJudge.length;++i){
            tmp.append(String.valueOf(intJudge[i]));
            if(i!=intJudge.length-1){
                tmp.append("|");
            }
        }
        judge = tmp.toString();
    }
    public ManagerGoodTable toGoodTable(){
        ManagerGoodTable key = new ManagerGoodTable();
        key.setId(this.id);
        key.setGoodname(this.goodname);
        key.setPalce(this.province+','+this.detailPlace);
        key.setPrice(this.price);
        key.setNumber(this.number);
        key.setTradeNum(this.tradenum);
        String[] tmp = this.judge.trim().split("\\|");

        if(tmp.length!=2){
            key.setJudge("Wrong");
        }
        else{
            StringBuilder out = new StringBuilder();
            out.append("好评"+tmp[1]);
            out.append(",");
            out.append("差评"+tmp[0]);
            key.setJudge(out.toString());
        }
        if(this.ischeck!=1){
            key.setState(this.ischeck==0?"等待审核":"驳回");
        }
        else {
            key.setState(isshelf==1?"上架":"下架");
        }
        return key;
    }

    public void  toState(){
        if(this.ischeck!=1){
           setTmp(this.ischeck==0?"等待审核":"驳回");
        }
        else {
            setTmp(isshelf==1?"上架":"下架");
        }
    }
    public int getTradenum() {
        return tradenum;
    }

    public void setTradenum(int tradenum) {
        this.tradenum = tradenum;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Good(){id=-1;point=0;intJudge = new Integer[2];}

    public int getIsshelf() {
        return isshelf;
    }

    public void setIsshelf(int isshelf) {
        this.isshelf = isshelf;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDetailPlace() {
        return detailPlace;
    }

    public void setDetailPlace(String detailPlace) {
        this.detailPlace = detailPlace;
    }

    public int getIscheck() {
        return ischeck;
    }

    public void setIscheck(int ischeck) {
        this.ischeck = ischeck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public Integer[] getIntJudge() {
        return intJudge;
    }

    public void setIntJudge(Integer[] intJudge) {
        this.intJudge = intJudge;
    }

    public String getTmp() {
        return tmp;
    }

    public void setTmp(String tmp) {
        this.tmp = tmp;
    }
}
