package com.jk.model.log;

import com.alibaba.fastjson.annotation.JSONField;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LogBean implements Serializable {


    public String id;

    public String log;


    public Date logTime;

    public String ip;

    public String requestMsg;

    public String responseMsg;

    public String ipAddress;

    public String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getLogTime() {


        String format = null;
        if (logTime!=null){
            format = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            format = sdf.format(logTime);
        }

        return format;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getRequestMsg() {
        return requestMsg;
    }

    public void setRequestMsg(String requestMsg) {
        this.requestMsg = requestMsg;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
