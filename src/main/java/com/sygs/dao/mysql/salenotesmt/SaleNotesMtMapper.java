package com.sygs.dao.mysql.salenotesmt;

import com.sygs.pojo.mysql.salenotesmt.SaleNotesMt;
import com.sygs.pojo.sqlserver.salenotesmt.SaleNotesMtSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface SaleNotesMtMapper {
    int deleteByPrimaryKey(@Param("billno") String billno, @Param("entid") String entid);

    int insert(SaleNotesMt record);

    int insertSelective(SaleNotesMt record);

    SaleNotesMt selectByPrimaryKey(@Param("billno") String billno, @Param("entid") String entid);

    int updateByPrimaryKeySelective(SaleNotesMt record);


    int updateByPrimaryKey(SaleNotesMt record);

    SaleNotesMt find(SaleNotesMt record);

    List<SaleNotesMt> list(SaleNotesMt record);
}
