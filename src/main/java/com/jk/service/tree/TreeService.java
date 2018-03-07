package com.jk.service.tree;

import com.jk.model.tree2.Tree;

import java.util.List;


public interface TreeService {

    /**
     *
     * @return 返回菜单树集合
     * @param pid 父ID
     */
    List<Tree> selectTree(String pid);
}
