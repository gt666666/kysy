package com.sygs.dao.sqlserver.salenotesmt;

import com.sygs.pojo.mysql.salenotesmt.SaleNotesMt;
import com.sygs.pojo.sqlserver.salenotesmt.SaleNotesMtSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface SaleNotesMtSqlMapper {
    int deleteByPrimaryKey(@Param("billno") String   billno,@Param("entid") String  entid);

    int insert(SaleNotesMtSql record);

    int insertSelective(SaleNotesMtSql record);

    SaleNotesMtSql selectByPrimaryKey(@Param("billno") String   billno,@Param("entid") String  entid );

    int updateByPrimaryKeySelective(SaleNotesMtSql record);

    int updateByPrimaryKeyWithBLOBs(SaleNotesMtSql record);

    int updateByPrimaryKey(SaleNotesMtSql record);

    SaleNotesMtSql find(SaleNotesMtSql record);

    List<SaleNotesMtSql> list(SaleNotesMtSql record);

    SaleNotesMt viewOaSaleNotesMt(@Param("billno") String   billno, @Param("entid") String  entid);
}