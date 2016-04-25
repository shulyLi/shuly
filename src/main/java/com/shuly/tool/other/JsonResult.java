package com.shuly.tool.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonResult {

    public static Map<String, Object> ok(Object data) {
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("code", true);
        ret.put("msg", "");
        ret.put("data", data);
        ret.put("goto","");
        return ret;
    }
    public static Map<String, Object> ok(Object data,String go) {
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("code", true);
        ret.put("msg", "");
        ret.put("data", data);
        ret.put("goto",go);
        return ret;
    }
    /*
    public static Map<String, Object> ok(Object data, Map<String, Object> ext) {
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("code", true);
        ret.put("msg", "");
        ret.put("data", data);
        ret.put("goto","");
        for (Map.Entry<String, Object> et : ext.entrySet()) {
            ret.put(et.getKey(), et.getValue());
        }
        return ret;
    }
    */
    public static Map<String, Object> error(String message) {
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("code", false);
        ret.put("msg", message);
        ret.put("data",false);
        ret.put("goto","");
        return ret;
    }
    public static Map<String, Object> error(String message,String go) {
        Map<String, Object> ret = new HashMap<String, Object>();
        ret.put("code", false);
        ret.put("msg", message);
        ret.put("data",false);
        ret.put("goto",go);
        return ret;
    }

    public static Map<String, Object> mailOk(Object data,int[] num) {
        Map<String, Object> ret = new HashMap<String, Object>();
        ArrayList<Map> NUM = new ArrayList<Map>();
        ret.put("code", true);
        ret.put("msg","");
        ret.put("data",data);
        ret.put("num",NUM);
        ret.put("goto","");
        for(int i=0;i<num.length;i++){
            Map tmp=new HashMap<String, Object>();
            NUM.add(tmp);
            tmp.put("id",i==0?1:i+4);
            tmp.put("val",num[i]);
        }
        return ret;
    }
}
