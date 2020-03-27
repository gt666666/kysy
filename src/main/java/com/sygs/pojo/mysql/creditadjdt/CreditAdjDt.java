package com.sygs.pojo.mysql.creditadjdt;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
@XmlRootElement(name = "CreditAdjDt")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditAdjDttResponse", namespace = "CreditAdjDt")
public class CreditAdjDt  implements Serializable {
    private Integer billno;

    private String entid;

    private Integer billsn;

    private Boolean status;

    private String clientcode;

    private String businessname;

    private String oppdepartment;

    private String khdj;

    private String staffname;

    private String ywy;

    private String kKhlx;

    private BigDecimal kCedbl;

    private BigDecimal xinded;

    private Integer xindts;

    private BigDecimal kXsxde;

    private Integer kXsxdq;

    private BigDecimal kLsxinded;

    private BigDecimal kLsxindts;

    private String adjddate;

    private BigDecimal kXyzq;

    private String kDybcqrq;

    private BigDecimal kYccje;

    private BigDecimal kJqxl;

    private String opporgname;

    private String reason;

    private String remark;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;


}