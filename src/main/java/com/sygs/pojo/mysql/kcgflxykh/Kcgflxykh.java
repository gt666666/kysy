package com.sygs.pojo.mysql.kcgflxykh;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Kcgflxykh implements Serializable {
    private Integer billno;

    private String entid;

    private Integer billsn;

    private Boolean status;

    private String businesscode;

    private String businessname;

    private String department;

    private String kZhangqilx;

    private BigDecimal taxamount;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;

}