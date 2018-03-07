package com.jk.model.User;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class User implements Serializable {

    public Integer id;

    public String name;

    public String loginnumber;

    public String password;

    public Integer sex;

    public Integer deptid;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    public Date createtime;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    public Date beginStime;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    public Date endStime;

    public Date getBeginStime() {
        return beginStime;
    }

    public void setBeginStime(Date beginStime) {
        this.beginStime = beginStime;
    }

    public Date getEndStime() {
        return endStime;
    }

    public void setEndStime(Date endStime) {
        this.endStime = endStime;
    }

    public String details;

    public String heading;

    public String deptname;

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public Integer getSex() {
        /*String sexStr ="";
        if (sex==1){ sexStr="男"; }else { sexStr="女"; };*/

        return sex;
    }

    public Integer getId() {
        return id;
    }

    public String getLoginnumber() {
        return loginnumber;
    }

    public String getCreatetime() {
        String format = null;
        if (createtime!=null){
            format = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            format = sdf.format(createtime);
        }
        return format;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public String getDetails() {
        return details;
    }

    public String getHeading() {
        return heading;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public void setLoginnumber(String loginnumber) {
        this.loginnumber = loginnumber;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loginnumber='" + loginnumber + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", deptid=" + deptid +
                ", createtime=" + createtime +
                ", beginStime=" + beginStime +
                ", endStime=" + endStime +
                ", details='" + details + '\'' +
                ", heading='" + heading + '\'' +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}
