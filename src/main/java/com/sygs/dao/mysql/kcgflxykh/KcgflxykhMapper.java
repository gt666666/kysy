package com.sygs.dao.mysql.kcgflxykh;

import com.sygs.pojo.mysql.kcgflxykh.Kcgflxykh;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface KcgflxykhMapper {
    int deleteByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int insert(Kcgflxykh record);

    int insertSelective(Kcgflxykh record);

    Kcgflxykh selectByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int updateByPrimaryKeySelective(Kcgflxykh record);

    int updateByPrimaryKey(Kcgflxykh record);

    Kcgflxykh find(Kcgflxykh record);

    List<Kcgflxykh> list(Kcgflxykh record);
}