package com.sygs.pojo.sqlserver.kcgflxyzc;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class KcgflxyzcSql  implements Serializable {
    private Integer billno;

    private String entid;

    private Integer billsn;

    private Boolean status;

    private String goodscode;

    private String goodsname;

    private String goodsspec;

    private String manufacturer;

    private String place;

    private BigDecimal purprice;

    private String kXyprice;

    private BigDecimal kZdsj;

    private BigDecimal kLsflbl;

    private BigDecimal kFlydbl;

    private BigDecimal kFljdbl;

    private BigDecimal kFlndbl;

    private BigDecimal rebamt;

    private BigDecimal taxprice;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;


}