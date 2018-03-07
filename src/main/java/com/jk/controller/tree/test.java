package com.jk.controller.tree;

import com.jk.model.tree2.Tree;
import com.jk.service.tree.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "test")
public class test {

    @Autowired
    public TreeService treeService;

    @RequestMapping(value = "selectTree")
    @ResponseBody
    public List<Tree> selectTree(){
        String pid = "0";
        List<Tree> list = treeService.selectTree(pid);
        for (Tree tree : list) {
            List<Tree> listSon = treeService.selectTree(tree.getId());
            if ( listSon!=null && listSon.size()>0){
                tree.setChildren(listSon);
            }
        }
        System.out.println(22);
        return list;
    }
}
