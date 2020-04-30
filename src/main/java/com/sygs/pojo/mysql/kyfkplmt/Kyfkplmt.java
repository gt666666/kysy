package com.sygs.pojo.mysql.kyfkplmt;

import com.sygs.pojo.mysql.kyfkpldt.Kyfkpldt;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class Kyfkplmt implements Serializable {

    private List<Kyfkpldt> kyfkpldts;

    private Integer billno;

    private String entid;

    private String billcode;

    private String mobile;

    private  Boolean  isQushu;

    private Boolean status;

    private String dates;

    private String startdate;

    private String enddate;

    private String caozyname;

    private BigDecimal sumtaxamount;

    private BigDecimal sumzp;

    private String sumcd3;

    private BigDecimal sumdh;

    private BigDecimal sumcd6;

    private String staffname;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;

    private String remark;

    private String msg;

    private Integer code;


}