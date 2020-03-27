package com.sygs.dao.mysql.kcgflxyqd;

import com.sygs.pojo.mysql.kcgflxyqd.Kcgflxyqd;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface KcgflxyqdMapper {
    int deleteByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int insert(Kcgflxyqd record);

    int insertSelective(Kcgflxyqd record);

    Kcgflxyqd selectByPrimaryKey(@Param("billno") Integer billno, @Param("entid") String entid);

    int updateByPrimaryKeySelective(Kcgflxyqd record);

    int updateByPrimaryKey(Kcgflxyqd record);

    Kcgflxyqd find(Kcgflxyqd record);

    List<Kcgflxyqd> list(Kcgflxyqd record);
}