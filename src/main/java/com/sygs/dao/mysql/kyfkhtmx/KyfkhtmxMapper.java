package com.sygs.dao.mysql.kyfkhtmx;

import com.sygs.pojo.mysql.kyfkhtmx.Kyfkhtmx;
import com.sygs.pojo.mysql.salenotesdt.SaleNotesDt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface KyfkhtmxMapper {
    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(Kyfkhtmx record);

    int insertSelective(Kyfkhtmx record);

    Kyfkhtmx selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(Kyfkhtmx record);

    int updateByPrimaryKeyWithBLOBs(Kyfkhtmx record);

    int updateByPrimaryKey(Kyfkhtmx record);

    Kyfkhtmx find(Kyfkhtmx record);

    List<Kyfkhtmx> list(Kyfkhtmx record);
    boolean insertForeach (List<Kyfkhtmx>  list);
}