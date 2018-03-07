package com.jk.controller.log;

import com.jk.model.User.User;
import com.jk.model.result.ResultBean;
import com.jk.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "selectLogList")
    @ResponseBody
    public HashMap<String, Object> selectUserList(Integer page, Integer pageSize){
        page =1;
        pageSize = 10;
        Integer rows = pageSize;
        ResultBean resultBean = loginService.selectLog(page, rows);
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();

       /* stringObjectHashMap.put("pageAlwaysSize",pageAlwaysSize);
        stringObjectHashMap.put("list",list);*/
        stringObjectHashMap.put("code",resultBean.getCode());
        stringObjectHashMap.put("msg",resultBean.getMsg());
        Map<String, Object> qwe = (Map<String, Object>) resultBean.getData();
        stringObjectHashMap.put("count",qwe.get("total"));
        stringObjectHashMap.put("data",qwe.get("rows"));
        System.out.println(22);

        return stringObjectHashMap;
    }
}
