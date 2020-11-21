package com.myapplication.xt.Controller;

import com.myapplication.xt.entity.Xt_canteen_rsv;
import com.myapplication.xt.service.Xt_canteen_rsvService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CanteenController {

    @Resource
    private Xt_canteen_rsvService xt_canteen_rsvService;

    @RequestMapping("/index.html")
    public String index(Model model){
        List<Xt_canteen_rsv> xt_canteen_rsv =xt_canteen_rsvService.getAll();
        model.addAttribute("xt_canteen_rsv",xt_canteen_rsv);
        return "index";
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map getDel(Long id){
        boolean del =xt_canteen_rsvService.delete(id);
        Map map = new HashMap();
        if (del){
            map.put("ok",true);
        }else{
            map.put("ok",false);
        }
        return map;
    }
}
