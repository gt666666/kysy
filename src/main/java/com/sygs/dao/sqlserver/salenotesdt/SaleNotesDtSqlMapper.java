package com.sygs.dao.sqlserver.salenotesdt;

import com.sygs.pojo.mysql.salenotesdt.SaleNotesDt;
import com.sygs.pojo.sqlserver.salenotesdt.SaleNotesDtSql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SaleNotesDtSqlMapper {
    int deleteByPrimaryKey(@Param("billno") String billno, @Param("entid") String entid,@Param("billsn") String billsn);

    int insert(SaleNotesDtSql record);

    int insertSelective(SaleNotesDtSql record);

    SaleNotesDtSql selectByPrimaryKey(@Param("billno") String billno, @Param("entid") String entid,@Param("billsn") String billsn);

    int updateByPrimaryKeySelective(SaleNotesDtSql record);

    int updateByPrimaryKey(SaleNotesDtSql record);

    SaleNotesDtSql find(SaleNotesDtSql record);

    List<SaleNotesDtSql> list(SaleNotesDtSql record);

    List<SaleNotesDt>   ViewOASaleNotesDt(@Param("billno") String billno, @Param("entid") String entid);
}