package com.sygs.dao.mysql.mastername;

import com.sygs.pojo.mysql.mastername.Mastername;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface MasternameMapper {
    int deleteByPrimaryKey(Long mid);

    int insert(Mastername record);

    int insertSelective(Mastername record);

    Mastername selectByPrimaryKey(Long mid);

    int updateByPrimaryKeySelective(Mastername record);

    int updateByPrimaryKey(Mastername record);

    Mastername find(Mastername record);

    List<Mastername> list(Mastername record);
}