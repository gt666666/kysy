package com.sygs.pojo.mysql.creditadjmt;

import com.sygs.pojo.mysql.creditadjdt.CreditAdjDt;
import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@XmlRootElement(name = "CreditAdjMt")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditAdjMtResponse", namespace = "CreditAdjMt")
public class CreditAdjMt implements Serializable {
    private List<CreditAdjDt> creditAdjDts;

    private Integer billno;

    private String entid;

    private Boolean status;

    private String dates;

    private String ontime;

    private String billcode;

    private String staffname;

    private String kTztype;

    private String kZxlx;

    private String adjusttype;

    private String kCnhkrq;

    private BigDecimal kCnhkje;

    private String remark;

    private String kBcsh;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;

}