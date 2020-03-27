package com.sygs.pojo.sqlserver.kcgflxybm;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class KcgflxybmSql implements Serializable {
    private Integer billno;

    private String entid;

    private Integer billsn;

    private Boolean status;

    private String department;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;

}