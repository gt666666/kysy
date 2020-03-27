package com.sygs.dao.mysql.kcgflxybm;

import com.sygs.pojo.mysql.kcgflxybm.Kcgflxybm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface KcgflxybmMapper {

    int deleteByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int insert(Kcgflxybm record);

    int insertSelective(Kcgflxybm record);

    Kcgflxybm selectByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int updateByPrimaryKeySelective(Kcgflxybm record);

    int updateByPrimaryKey(Kcgflxybm record);

    Kcgflxybm find(Kcgflxybm record);

    List<Kcgflxybm> list(Kcgflxybm record);
}