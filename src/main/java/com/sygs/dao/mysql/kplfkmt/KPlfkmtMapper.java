package com.sygs.dao.mysql.kplfkmt;

import com.sygs.pojo.mysql.kplfkmt.KPlfkmt;
import com.sygs.pojo.mysql.kyfkplmt.Kyfkplmt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
@Component
public interface KPlfkmtMapper {

    int deleteByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int insert(KPlfkmt record);

    int insertSelective(KPlfkmt record);

    KPlfkmt selectByPrimaryKey(@Param("billno") Integer Integer, @Param("entid") String entid);

    int updateByPrimaryKeySelective(KPlfkmt record);

    int updateByPrimaryKey(KPlfkmt record);

    KPlfkmt find(KPlfkmt record);

    List<KPlfkmt> list(KPlfkmt record);
}