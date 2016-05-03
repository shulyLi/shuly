package com.shuly.tool.other;

import com.shuly.tool.pojo.Deal;
import com.shuly.tool.pojo.Good;
import com.shuly.tool.table.DealTable;

import java.sql.Timestamp;

/**
 * Created by shuly on 16-4-17.
 */
public class Tool {
    public static String  dealState[] ={"刚提交的订单","商家受理的订单","商家拒绝的订单","用户终止的","完成的订单"};
    public static DealTable getDealTable(Good good, Deal deal) {
        DealTable ans = new DealTable();
        ans.setId(deal.getId());
        ans.setGoodName(good.getGoodname());
        ans.setGoodNum(deal.getNum());
        ans.setGoodPrice(deal.getGoodPrice()+deal.getTradePrice());
        ans.setGoodState(dealState[deal.getStates()]);
        ans.setCreate_time(deal.getCreate_time().toString());
        return ans;
    }
}
