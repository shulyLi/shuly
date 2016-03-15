package com.shuly.tool.pojo;
import java.sql.Timestamp;
/**
 * Created by shuly on 16-3-1.
 */
public class Good {
    int id;
    String name;
    String user_telnum;
    String pic_url;
    String mes;
    Timestamp create_time;
    public Good(){}
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString(){
        return getName()+getPic_url()+getCreate_time()+getMes()+getUser_telnum()+"|||"+getId();
    }
}
