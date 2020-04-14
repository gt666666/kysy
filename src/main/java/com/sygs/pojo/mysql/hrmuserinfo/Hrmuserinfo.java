package com.sygs.pojo.mysql.hrmuserinfo;

import lombok.Data;

import java.io.Serializable;
@Data
public class Hrmuserinfo implements Serializable {
    private Integer id;

    private String loginid;

    private String lastname;

    private String departmentid;

    private String jobtitle;


}