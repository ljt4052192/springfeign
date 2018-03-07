package com.jk.service.login;

import com.jk.model.log.LogBean;
import com.jk.model.result.ResultBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "PROVIDER-LOG", fallback = LoginServiceHystric.class)
@Service
public interface LoginService {

    @RequestMapping("/log/insertLog")
    void insertLog( @RequestParam("log") String log);

    @RequestMapping("/log/selectLog")
    ResultBean selectLog(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);
}
