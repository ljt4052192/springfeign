package com.jk.model.tree2;

import java.io.Serializable;
import java.util.List;

public class Tree implements Serializable{

    public String title;

    public String icon;

    public String spread;

    public String href;

    public String id;

    public List<Tree> children;

    public String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", spread='" + spread + '\'' +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", children=" + children +
                ", pid='" + pid + '\'' +
                '}';
    }
}
