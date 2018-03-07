package com.jk.service.tree;

import com.jk.mapper.tree2.Tree2Mapper;
import com.jk.model.tree2.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    public Tree2Mapper tree2Mapper;



    public List<Tree> selectTree(String pid) {
        return tree2Mapper.selectTree(pid);
    }
}
