package com.jk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Controller
public class SpringfeignApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringfeignApplication.class, args);
	}

	/**
	 * 支持jsp需要重写此方法
	 * @param builder
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

	/*@Value("${foo}")
	String foo;*/

/*	@RequestMapping("/springfeign-demo.yml")
	@ResponseBody
	public String asd(){


	}*/

}
