package com.sygs.dao.mysql.kyfkpldt;

import com.sygs.pojo.mysql.kyfkpldt.Kyfkpldt;
import com.sygs.pojo.mysql.salenotesdt.SaleNotesDt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface KyfkpldtMapper {
    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(Kyfkpldt record);

    int insertSelective(Kyfkpldt record);

    Kyfkpldt selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(Kyfkpldt record);

    int updateByPrimaryKey(Kyfkpldt record);

    Kyfkpldt find(Kyfkpldt record);

    List<Kyfkpldt> list(Kyfkpldt record);

    boolean insertForeach (List<Kyfkpldt>  list);
}