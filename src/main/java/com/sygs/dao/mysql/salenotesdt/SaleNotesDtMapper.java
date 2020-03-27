package com.sygs.dao.mysql.salenotesdt;

import com.sygs.pojo.mysql.salenotesdt.SaleNotesDt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface SaleNotesDtMapper {
    int deleteByPrimaryKey(@Param("billno") String billno,@Param("entid") String entid,@Param("billsn") String billsn);

    int insert(SaleNotesDt record);

    int insertSelective(SaleNotesDt record);

    SaleNotesDt selectByPrimaryKey(@Param("billno") String billno, @Param("entid") String entid);

    int updateByPrimaryKeySelective(SaleNotesDt record);

    int updateByPrimaryKey(SaleNotesDt record);

    SaleNotesDt find(SaleNotesDt record);

    List<SaleNotesDt> list(SaleNotesDt record);

    boolean insertForeach (List<SaleNotesDt>  list);
}