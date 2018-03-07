package com.jk.service.login;

import com.jk.model.result.ResultBean;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceHystric implements LoginService{
    @Override
    public void insertLog(String log) {
        System.out.println("日志微服务挂了，断路器生效");
    }

    @Override
    public ResultBean selectLog(Integer page, Integer rows) {
        System.out.println("日志微服务挂了，断路器生效");
        return null;
    }
}
