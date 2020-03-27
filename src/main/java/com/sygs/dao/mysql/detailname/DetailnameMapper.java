package com.sygs.dao.mysql.detailname;

import com.sygs.pojo.mysql.detailname.Detailname;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface DetailnameMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Detailname record);

    int insertSelective(Detailname record);

    Detailname selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Detailname record);

    int updateByPrimaryKey(Detailname record);

    Detailname find(Detailname record);
    List<Detailname> listQuery(Detailname record);
    List<Detailname> list(Long  mid);
    int   deleteBYMasternamePrimaryKey(Long  id);
}