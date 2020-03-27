package com.sygs.dao.mysql.kfkpldt;

import com.sygs.pojo.mysql.creditadjdt.CreditAdjDt;
import com.sygs.pojo.mysql.kfkpldt.Kfkpldt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface KfkpldtMapper {
    boolean insertForeach (List<Kfkpldt>  list);
    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(Kfkpldt record);

    int insertSelective(Kfkpldt record);

    Kfkpldt selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(Kfkpldt record);

    int updateByPrimaryKey(Kfkpldt record);

    Kfkpldt find(Kfkpldt record);

    List<Kfkpldt> list(Kfkpldt record);
}