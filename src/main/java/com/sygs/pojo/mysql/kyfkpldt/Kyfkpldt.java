package com.sygs.pojo.mysql.kyfkpldt;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sygs.pojo.mysql.kyfkhtmx.Kyfkhtmx;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class Kyfkpldt  implements Serializable {
    private List<Kyfkhtmx> kyfkhtmxes;
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