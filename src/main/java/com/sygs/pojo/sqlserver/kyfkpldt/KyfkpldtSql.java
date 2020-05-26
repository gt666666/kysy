package com.sygs.pojo.sqlserver.kyfkpldt;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class KyfkpldtSql  implements Serializable {
    private String kyj1;

    private String kyj2;

    private Integer billno;

    private String entid;

    private Integer billsn;

    private Integer rfbillno;

    private Boolean status;

    private String kIsty;

    private String rfbillcode;

    private String businesscode;

    private String businessname;

    private String kDeptid;

    private String caozyname;

    private BigDecimal kYfye;

    private BigDecimal kKcje;

    private BigDecimal amount;

    private String kPaytype;

    private BigDecimal kCgoujje;

    private BigDecimal kFukje;

    private BigDecimal kJxspye;

    private BigDecimal kBefore90xshe;

    private String kYwyname;

    private BigDecimal kOldyfye;

    private String kDepartment;

    private String contact;

    private BigDecimal kMaolv;

    private String kYfyj;

    private String remark;

    private String kYj4;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;


}