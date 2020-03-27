package com.sygs.dao.sqlserver.kndxy;

import com.sygs.pojo.mysql.kndxy.Kndxy;
import com.sygs.pojo.sqlserver.kndxy.KndxySql;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface KndxySqlMapper {
    Kndxy viewOaKndxy(Map<String ,Object>  map);
    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KndxySql record);

    int insertSelective(KndxySql record);

    KndxySql selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KndxySql record);


    int updateByPrimaryKey(KndxySql record);

    KndxySql find(KndxySql record);

    List<KndxySql> list(KndxySql record);
}