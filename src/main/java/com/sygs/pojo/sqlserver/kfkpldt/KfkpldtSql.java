package com.sygs.pojo.sqlserver.kfkpldt;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class KfkpldtSql implements Serializable {
    private String Kyj1;

    private String Kyj2;

    private String Kyj3;
    private Integer billno;

    private String entid;

    private Integer billsn;

    private Integer rfbillno;

    private String rfbillcode;

    private String businesscode;

    private String businessname;

    private String kDepartment;

    private String caozyname;

    private BigDecimal kYfye;

    private BigDecimal kKcje;

    private BigDecimal kCyje;

    private String kPaytype;

    private String kJsfs;

    private BigDecimal kCgoujje;

    private BigDecimal kFukje;

    private BigDecimal kJxspye;

    private BigDecimal kBefore90xshe;

    private String dates;

    private String ontime;

    private String oppcontact;

    private BigDecimal kMaolv;

    private Boolean status;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;


}