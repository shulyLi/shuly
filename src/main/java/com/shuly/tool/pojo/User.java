
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
    String add;
    String telnum;
    int levelr;
    int point;
    int utype;
    int ischeck;
    Timestamp create_time;
    Timestamp last_visit_time;
    String pic;

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public User() {
        id =-1;
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getUtype() {
        return utype;
    }

    public void setUtype(int utype) {
        this.utype = utype;
    }

    @Override
    public String toString(){
        return getUsername()+getEmailr()+getPassword();
    }
}
