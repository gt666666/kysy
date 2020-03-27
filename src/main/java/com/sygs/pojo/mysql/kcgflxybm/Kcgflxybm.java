package com.sygs.pojo.mysql.kcgflxybm;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Data
public class Kcgflxybm implements Serializable {
    private Integer billno;

    private String entid;

    private Integer billsn;

    private Boolean status;

    private String department;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;


}