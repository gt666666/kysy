package com.sygs.pojo.mysql.salenotesmt;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sygs.config.convert.CustomDateChange;
import com.sygs.pojo.mysql.salenotesdt.SaleNotesDt;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@XmlRootElement(name = "SaleNotesMt")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SaleNotesMtResponse", namespace = "SaleNotesMtRes")
public class SaleNotesMt implements Serializable {

    private String billno;

    private String entid;

    private Boolean status;

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

    private List<SaleNotesDt> saleNotesDts;

    private String TaxAmount;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;

    private String msg;

    private Integer code;


}