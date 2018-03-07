package com.jk.controller.user;

import com.jk.model.User.User;
import com.jk.service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "user")
public class userController {


    @Autowired
    public UserService userService;

    @RequestMapping(value = "selectUserList")
    @ResponseBody
    public HashMap<String, Object> selectUserList(Integer page, Integer pageSize){
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        Integer size = userService.selectUserListAlwaysSize();
        page =1;
        pageSize = 10;
        List<User> list = userService.selectUserList(page,pageSize);

        Integer pageAlwaysSize =  size%pageSize==0 ? size/pageSize : size/pageSize+1;
       /* stringObjectHashMap.put("pageAlwaysSize",pageAlwaysSize);
        stringObjectHashMap.put("list",list);*/
        stringObjectHashMap.put("code",0);
        stringObjectHashMap.put("msg","");
        stringObjectHashMap.put("count",size);
        stringObjectHashMap.put("data",list);
        System.out.println(22);

        return stringObjectHashMap;
    }

    @RequestMapping(value = "DelectUser")
    @ResponseBody
    public void DelectUser(String id){
        userService.DelectUser(id);
    }

    @RequestMapping(value = "addUser")
    @ResponseBody
    public String addUser(User user){
        HashMap<String, Object> stringObjectHashMap2 = new HashMap<String, Object>();
        if (user.getDetails()==null){
            user.setDetails("暂无");
        }
        user.setCreatetime(null);
        userService.addUser(user);
        System.out.println(22);
        //1为新增成功
        stringObjectHashMap2.put("static",1);

        return "{}";
    }



}
