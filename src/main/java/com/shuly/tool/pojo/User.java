
package com.shuly.tool.pojo;
import java.sql.Timestamp;

/**
 * Created by shuly on 16-3-1.
 */
public class User {
    int id;
    String username;
    String password;
    String emailr;
    String telnum;
    int levelr;
    String last_ip;
    Timestamp create_time;
    Timestamp last_visit_time;
    public User(){
        this.telnum="1";
        this.levelr=1;
        this.last_ip="0.0.0.0";
        this.create_time=new Timestamp(System.currentTimeMillis());
        this.last_visit_time=this.create_time;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passsword) {
        this.password = passsword;
    }

    public String getEmailr() {
        return emailr;
    }

    public void setEmailr(String emailr) {
        this.emailr = emailr;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    public int getLevelr() {
        return levelr;
    }

    public void setLevelr(int levelr) {
        this.levelr = levelr;
    }

    public String getLast_ip() {
        return last_ip;
    }

    public void setLast_ip(String last_ip) {
        this.last_ip = last_ip;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public Timestamp getLast_visit_time() {
        return last_visit_time;
    }

    public void setLast_visit_time(Timestamp last_visit_time) {
        this.last_visit_time = last_visit_time;
    }

    @Override
    public String toString(){
        return getUsername()+getEmailr()+getPassword();
    }
}
