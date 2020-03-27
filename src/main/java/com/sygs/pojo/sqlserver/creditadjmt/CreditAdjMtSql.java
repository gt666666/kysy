package com.sygs.pojo.sqlserver.creditadjmt;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class CreditAdjMtSql implements Serializable {
    private Integer billno;

    private String entid;

    private Boolean status;

    private String dates;

    private String ontime;

    private String billcode;

    private String staffname;

    private String kTztype;

    private String kZxlx;

    private String adjusttype;

    private String kCnhkrq;

    private BigDecimal kCnhkje;

    private String remark;

    private String kBcsh;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;


}