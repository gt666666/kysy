package com.sygs.pojo.sqlserver.kyfkplmt;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class KyfkplmtSql implements Serializable {
    private String zjlzyj;

    private String cwzjzyj;

    private Integer billno;

    private String entid;

    private String billcode;

    private Byte status;

    private String dates;

    private String startdate;

    private String enddate;

    private String caozyname;

    private BigDecimal sumtaxamount;

    private BigDecimal sumzp;

    private String sumcd3;

    private BigDecimal sumdh;

    private BigDecimal sumcd6;

    private String staffname;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;

    private String remark;

}