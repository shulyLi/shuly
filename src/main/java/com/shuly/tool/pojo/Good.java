package com.shuly.tool.pojo;
import java.sql.Timestamp;
/**
 * Created by shuly on 16-3-1.
 */
public class Good {
    int id;
    String goodname;
    int user_id;
    String user_telnum;
    String pic_url;
    String mes;
    int point;
    Timestamp create_time;
    public Good(){id=-1;point =0;}
    public String getUser_telnum() {
        return user_telnum;
    }

    public void setUser_telnum(String user_telnum) {
        this.user_telnum = user_telnum;
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

    @Override
    public String toString(){
        return getGoodname()+getPic_url()+getCreate_time()+getMes()+getUser_telnum()+"|||"+getId();
    }
}
