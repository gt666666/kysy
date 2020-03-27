package com.sygs.pojo.mysql.detailname;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Detailname implements Serializable {
    private Long id;

    private String memberName;

    private Boolean isDelete;

    private Date createDate;

    private Date updateDate;

    private Long mid;

    private String detailTableName;
    private String detailTableDescription;



}