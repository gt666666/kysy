package com.sygs.dao.mysql;

import com.sygs.pojo.Member;
import org.apache.ibatis.annotations.Mapper;
/**
 * 类描述：
 * 创建作者：gt
 * 创建日期 ： 2019/11/19
 */
@Mapper
public interface IMemberDAO {
    public Member findById(String mid);
}
