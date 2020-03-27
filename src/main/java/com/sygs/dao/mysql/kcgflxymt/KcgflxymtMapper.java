package com.sygs.dao.mysql.kcgflxymt;

import com.sygs.pojo.mysql.kcgflxymt.Kcgflxymt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface KcgflxymtMapper {
    int deleteByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int insert(Kcgflxymt record);

    int insertSelective(Kcgflxymt record);

    Kcgflxymt selectByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int updateByPrimaryKeySelective(Kcgflxymt record);

    int updateByPrimaryKey(Kcgflxymt record);

    Kcgflxymt find(Kcgflxymt record);

    List<Kcgflxymt> list(Kcgflxymt record);
}