package com.sygs.pojo.mysql.kxsflxydt;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Kxsflxydt implements Serializable {
    private Integer billno;

    private String entid;

    private Integer billsn;

    private Boolean status;

    private String kXsflfs;

    private String goodscode;

    private String goodsname;

    private String goodsspec;

    private String place;

    private BigDecimal kXyprice;

    private BigDecimal kRwl;

    private BigDecimal kFlndbl;

    private BigDecimal kFlydbl;

    private BigDecimal taxprice;

    private BigDecimal kZbj;

    private String kQxscqkzh;

    private String regmark;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;

    private String remark;


}