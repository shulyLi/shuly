package com.shuly.tool.pojo;

import com.shuly.tool.table.MailTable;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.sql.Timestamp;

/**
 * Created by shuly on 16-4-13.
 */
public class Mail {
    int id;
    int owner_id;
    String from_user;
    String to_user;
    String head;
    String mes;
    Timestamp create_time;
    int isread;
    int mailtype;
    String filerar;
    public Mail(){
        id = -1;
        this.isread=0;
        this.create_time=new Timestamp(System.currentTimeMillis());
        this.filerar="";
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public MailTable toMailTable(){
        MailTable key = new MailTable();
        key.setId(this.id);
        key.setSub("<b>"+this.head+"</b> - "+this.mes.substring(0,Math.min(this.mes.length(),22)));
        key.setName(this.head);
        key.setDate(this.create_time);
        key.setIsread(this.isread);
        return key;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom_user() {
        return from_user;
    }

    public void setFrom_user(String from_user) {
        this.from_user = from_user;
    }

    public String getTo_user() {
        return to_user;
    }

    public void setTo_user(String to_user) {
        this.to_user = to_user;
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

    public int getIsread() {
        return isread;
    }

    public void setIsread(int isread) {
        this.isread = isread;
    }

    public int getMailtype() {
        return mailtype;
    }

    public void setMailtype(int type) {
        this.mailtype = type;
    }

    public String getFilerar() {
        return filerar;
    }

    public void setFilerar(String filerar) {
        this.filerar = filerar;
    }
}
