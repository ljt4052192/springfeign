package com.jk.controller.login;

import com.jk.model.log.LogBean;
import com.jk.service.log.LogThread;
import com.jk.service.login.LoginService;
import com.jk.utils.pool.ThreadPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping( value = "login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping( value = "login")
    @ResponseBody
    public Boolean login( String loginnumber, String password){

        LogBean logBean = new LogBean();
        logBean.setIp("127.0.0.1");
        logBean.setIpAddress("金科教育");
        logBean.setLog("login");
        logBean.setLogTime(new Date());
        logBean.setName("登录日志");
        logBean.setRequestMsg("loginnumber:"+loginnumber);
        logBean.setResponseMsg("嘀嘀嘀");
        ThreadPool.executor(new LogThread(loginService, logBean));

        return true;
    }
}
