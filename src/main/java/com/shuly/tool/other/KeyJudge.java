package com.shuly.tool.other;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuly on 16-4-11.
 */
public class KeyJudge {


    static String [] PROVINCE = {"北京市","天津市","上海市","重庆市","河北省","山西省","内蒙古","辽宁省","吉林省","黑龙江省","江苏省","浙江省","安徽省","福建省","江西省","山东省","河南省","湖北省","湖南省","广东省","广西","海南省","四川省","贵州省","云南省","西藏","陕西省","甘肃省","青海省","宁夏","新疆","香港","澳门","台湾省"};
    Map PROVINCEMAP;
    void initProvinceMap(){
        PROVINCEMAP = new HashMap<String,Boolean>();
        for(int i=0;i<PROVINCE.length;i++){
            PROVINCEMAP.put(PROVINCE[i],true);
        }
    }
    public KeyJudge(){
        initProvinceMap();
    }
    public boolean isProvinceOk(String tmp){
        return PROVINCEMAP.containsKey(tmp);
    }
    public String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
