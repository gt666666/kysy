package com.sygs.pojo.mysql.mastername;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sygs.config.convert.CustomDateChange;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
@Data
public class Mastername implements Serializable {
    private Long mid;
    private String memberName;
    private Boolean isDelete;
    //@JsonSerialize(using = CustomDateChange.class)
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;
    private String masterTableDescription;
    private String masterTableName;
    private String detailTableName1;
    private String detailTableName2;
    private String detailTableName3;
    private String detailTableName4;
    private String detailTableName5;
}