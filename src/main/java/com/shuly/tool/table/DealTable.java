package com.shuly.tool.table;

import java.sql.Timestamp;

/**
 * Created by shuly on 16-4-28.
 */
public class DealTable {
    int id;
    String goodName;
    int goodNum;
    Double goodPrice;
    String goodState;
    String create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(int goodNum) {
        this.goodNum = goodNum;
    }

    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodState() {
        return goodState;
    }

    public void setGoodState(String goodState) {
        this.goodState = goodState;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }
}
