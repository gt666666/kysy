package com.sygs.pojo.mysql.kplfkmt;

import com.sygs.pojo.mysql.kfkpldt.Kfkpldt;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class KPlfkmt  implements Serializable {
    private String gs;

    private String deptId;

    private String mobile;

    private Boolean isQushu;

    List<Kfkpldt>   kfkpldts;

    private Integer billno;

    private String entid;

    private Boolean status;

    private String dates;

    private String startdate;

    private String enddate;

    private String isBbm;

    private String staffname;

    private BigDecimal sumtaxamount;

    private String remark;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;


}