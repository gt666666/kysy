package com.sygs.dao.mysql.kcgflxyzc;

import com.sygs.pojo.mysql.kcgflxyzc.Kcgflxyzc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface KcgflxyzcMapper {
    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(Kcgflxyzc record);

    int insertSelective(Kcgflxyzc record);

    Kcgflxyzc selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(Kcgflxyzc record);

    int updateByPrimaryKey(Kcgflxyzc record);

    Kcgflxyzc find(Kcgflxyzc record);

    List<Kcgflxyzc> list(Kcgflxyzc record);
}