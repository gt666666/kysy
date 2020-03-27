package com.sygs.pojo.mysql.salenotesdt;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sygs.config.convert.CustomDateChange;
import lombok.Data;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;
@Data
@XmlRootElement(name="SaleNotesDt")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaleNotesDtResponse",namespace = "SaleNotesRes")
public class SaleNotesDt  implements Serializable {
    private String billno;

    private String entid;

    private String billsn;

    private Boolean status;

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