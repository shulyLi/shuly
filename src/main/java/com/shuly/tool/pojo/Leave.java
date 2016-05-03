package com.shuly.tool.pojo;

import com.shuly.tool.table.LeaveTable;

import java.sql.Timestamp;

/**
 * Created by shuly on 16-5-2.
 */
public class Leave {
    int id;
    int from_user;
    String  toName;
    int toId;
    int isRight;
    int lever;
    String mes;
    Timestamp create_time;
    static String [] L={"差评","一般","神了"};
    /*
        int id;
    int goodName;
    String isRight;
    String lever;
    String msg;
    Timestamp create_time;
     */
    public Leave(){id=-1;}
    public  LeaveTable toTable(){
        LeaveTable ans = new LeaveTable();
        ans.setId(this.id);
        ans.setGoodName(this.toName);
        ans.setIsRight(this.isRight==1?"评价完成":"没有评价");
        ans.setLever(this.isRight==1?L[lever+1]:"");
        ans.setMsg(this.mes.substring(0, this.mes.length()<16?this.mes.length():16 ) );
        ans.setCreate_time(this.create_time.toString());
        return ans;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrom_user() {
        return from_user;
    }

    public void setFrom_user(int from_user) {
        this.from_user = from_user;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public int getIsRight() {
        return isRight;
    }

    public void setIsRight(int isRight) {
        this.isRight = isRight;
    }

    public int getLever() {
        return lever;
    }

    public void setLever(int lever) {
        this.lever = lever;
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
}
