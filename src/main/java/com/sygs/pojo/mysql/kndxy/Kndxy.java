package com.sygs.pojo.mysql.kndxy;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Kndxy implements Serializable {
    private Integer billno;

    private String entid;

    private String billcode;

    private Boolean status;

    private String dates;

    private String ontime;

    private String startdate;

    private String enddate;

    private String businesscode;

    private String businessname;

    private String kZhangqilx;

    private String department;

    private String staffname;

    private String kKhfl;

    private String contractcode;

    private String legaler;

    private String delegation;

    private BigDecimal kOldje;

    private String kXindts1;

    private BigDecimal kXyzq;

    private String kZqtype;

    private String kKhlx;

    private Integer kXindts;

    private BigDecimal sxed;

    private String caozyname;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;

    private String kFlzc;


}