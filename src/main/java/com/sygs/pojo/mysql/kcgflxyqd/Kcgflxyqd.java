package com.sygs.pojo.mysql.kcgflxyqd;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Kcgflxyqd implements Serializable {
    private Integer billno;

    private String entid;

    private Integer billsn;

    private Boolean status;

    private String businesscode;

    private String businessname;

    private String kDepartment;

    private String oppcontact;

    private String tzdlsName;

    private String kIszgh;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;


}