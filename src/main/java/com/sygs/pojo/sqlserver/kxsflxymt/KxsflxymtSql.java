package com.sygs.pojo.sqlserver.kxsflxymt;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class KxsflxymtSql  implements Serializable {
    private Integer billno;

    private String entid;

    private Boolean status;

    private String billcode;

    private String dates;

    private String ontime;

    private String startdate;

    private String enddate;

    private String businesscode;

    private String businessname;

    private String caozyname;

    private String kDepartment;

    private String kZhangqilx;

    private String kXyh;

    private String kXsxylx;

    private BigDecimal kBwamount;

    private String kDxfs;

    private String kJslx;

    private String kQskj;

    private String kNumamount;

    private String kTaxtypes;

    private String kFlgz;

    private String kLxtype;

    private String kXyjsrq;

    private BigDecimal kRwl;

    private String isRwl;

    private String isZq;

    private BigDecimal ydBl;

    private BigDecimal ndBl;

    private BigDecimal bl;

    private BigDecimal rebamt;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;

    private String kZcbz;


}