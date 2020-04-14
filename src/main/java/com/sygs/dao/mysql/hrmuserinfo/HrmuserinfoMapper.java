package com.sygs.dao.mysql.hrmuserinfo;

import com.sygs.pojo.mysql.hrmuserinfo.Hrmuserinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface HrmuserinfoMapper {
    int insert(Hrmuserinfo record);

    int insertSelective(Hrmuserinfo record);

    Hrmuserinfo find(Hrmuserinfo record);

    List<Hrmuserinfo> list(Hrmuserinfo record);
    int  deleteAll();
}