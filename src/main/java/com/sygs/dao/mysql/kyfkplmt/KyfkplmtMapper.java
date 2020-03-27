package com.sygs.dao.mysql.kyfkplmt;

import com.sygs.pojo.mysql.kyfkplmt.Kyfkplmt;
import com.sygs.pojo.mysql.salenotesdt.SaleNotesDt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface KyfkplmtMapper {
    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(Kyfkplmt record);

    int insertSelective(Kyfkplmt record);

    Kyfkplmt selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(Kyfkplmt record);

    int updateByPrimaryKeyWithBLOBs(Kyfkplmt record);

    int updateByPrimaryKey(Kyfkplmt record);

    Kyfkplmt find(Kyfkplmt record);

    List<Kyfkplmt> list(Kyfkplmt record);

    boolean insertForeach (List<Kyfkplmt>  list);
}