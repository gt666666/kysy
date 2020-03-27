package com.sygs.pojo.sqlserver.salenotesmt;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class SaleNotesMtSql implements Serializable {
    private String billno;

    private String entid;

    private String dates;

    private String billcode;

    private String kChjtype;

    private String clientcode;

    private String businessname;

    private String department;

    private String oppcontact;

    private String staffname;

    private String kZhangqilx;

    private String kCgxyh;

    private String kNdbillcode;

    private String kBillcode;

    private String rebamt;

    private String kBwamount;

    private String kYwcje;

    private String kFlje;

    private String kWwcje;

    private String fcTaxamount;

    private String caozyname;

    private String isBbm;

    private String remark;

    private  String taxAmount;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;

}