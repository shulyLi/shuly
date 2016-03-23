package com.shuly.web;
import javax.servlet.http.HttpServletRequest;
import com.shuly.tool.pojo.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.shuly.dao.GoodsDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.shuly.tool.other.JacksonUtil;
/**
 * Created by shuly on 15-12-31.
 *
 */
@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    GoodsDao goodsDao;
    @RequestMapping(value = "/show.json")
    @ResponseBody
    public Object showGood(HttpServletRequest request ,
                           @RequestParam(value = "pageNum",required=true)Integer pageNum) {
        System.out.println(pageNum);
        Map<String, Object> out = new HashMap<String, Object>();
        List<Good> ans = goodsDao.getAll();
        return ans;
    }
    @RequestMapping("/last.json")
    @ResponseBody
    public Object benefitFileList(@RequestParam(value = "id", required = false) Integer id,
                                  @RequestParam(value = "start", required = false) Integer start,
                                  @RequestParam(value = "length", required = false) Integer length) throws Exception {
        Map<String, Object> out = new HashMap<String, Object>();
        out.put("nihao","woyehao");
        return out;
    }
}
