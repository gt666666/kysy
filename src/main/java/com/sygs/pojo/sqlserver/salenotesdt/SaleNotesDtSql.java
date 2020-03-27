package com.sygs.pojo.sqlserver.salenotesdt;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;
@Data
public class SaleNotesDtSql  implements Serializable {

    private String billno;

    private String entid;

    private String billsn;

    private Byte status;

    private String goodscode;

    private String goodsname;

    private String goodsspec;

    private String regmark;

    private String kQxscqkzh;

    private String manufacturer;

    private String unit;

    private String whname;

    private String batchcode;

    private String producedate;

    private String valdate;

    private String rate;

    private String num;

    private String oldtaxprice;

    private String newtaxprice;

    private String taxprice;

    private String kJsj;

    private String kNtaxcost;

    private String kOtaxcost;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;


}