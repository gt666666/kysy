package com.sygs.pojo.mysql.kyfkhtmx;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Kyfkhtmx implements Serializable {
    private Integer billno;

    private String entid;

    private Integer billsn;

    private Boolean status;

    private String goodscode;

    private String goodsname;

    private String goodsspec;

    private String place;

    private String manufacturer;

    private BigDecimal taxprice;

    private BigDecimal num;

    private String kQxscqkzh;

    private String regmark;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;

    private String remark;

}