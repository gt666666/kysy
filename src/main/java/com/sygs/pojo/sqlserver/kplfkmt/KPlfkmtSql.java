package com.sygs.pojo.sqlserver.kplfkmt;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class KPlfkmtSql implements Serializable {
    private Integer billno;

    private String entid;

    private Boolean status;

    private String dates;

    private String startdate;

    private String enddate;

    private String isBbm;

    private String staffname;

    private BigDecimal sumtaxamount;

    private String remark;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;


}