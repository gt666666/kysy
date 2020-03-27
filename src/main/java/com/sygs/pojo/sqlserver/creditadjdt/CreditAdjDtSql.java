package com.sygs.pojo.sqlserver.creditadjdt;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class CreditAdjDtSql  implements Serializable {
    private Integer billno;

    private String entid;

    private Integer billsn;

    private Boolean status;

    private String clientcode;

    private String businessname;

    private String oppdepartment;

    private String khdj;

    private String staffname;

    private String ywy;

    private String kKhlx;

    private BigDecimal kCedbl;

    private BigDecimal xinded;

    private Integer xindts;

    private BigDecimal kXsxde;

    private Integer kXsxdq;

    private BigDecimal kLsxinded;

    private BigDecimal kLsxindts;

    private String adjddate;

    private BigDecimal kXyzq;

    private String kDybcqrq;

    private BigDecimal kYccje;

    private BigDecimal kJqxl;

    private String opporgname;

    private String reason;

    private String remark;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;


}