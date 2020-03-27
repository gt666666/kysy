package com.sygs.dao.mysql.kndxy;

import com.sygs.pojo.mysql.kndxy.Kndxy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface KndxyMapper {
    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(Kndxy record);

    int insertSelective(Kndxy record);

    Kndxy selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(Kndxy record);

    int updateByPrimaryKey(Kndxy record);

    Kndxy find(Kndxy record);

    List<Kndxy> list(Kndxy record);
}