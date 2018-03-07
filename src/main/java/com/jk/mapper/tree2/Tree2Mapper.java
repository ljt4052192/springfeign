package com.jk.mapper.tree2;




import com.jk.model.tree2.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface Tree2Mapper {

    @Select("SELECT * FROM tree5 where pid = #{pid}")
    List<Tree> selectTree(@Param("pid") String pid);
}
