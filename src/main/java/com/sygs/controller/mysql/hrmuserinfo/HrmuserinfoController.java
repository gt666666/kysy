package com.sygs.controller.mysql.hrmuserinfo;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import com.sygs.controller.abs.AbstractBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sygs.enums.ResultEnum;
import com.sygs.utils.Page;
import com.github.pagehelper.PageHelper;
import com.sygs.utils.PaginationContext;
import com.sygs.pojo.CommonResult;
import com.sygs.pojo.mysql.hrmuserinfo.Hrmuserinfo;
import com.sygs.service.mysql.hrmuserinfo.HrmuserinfoService;
import sun.tools.java.Parser;

import java.util.List;

/**
 * 人力资源员工信息
 *
 * @author gaoting
 * @date：2020-04-14 10:36:06
 */
@RestController
@RequestMapping("/hrmuserinfo")
public class HrmuserinfoController extends AbstractBaseController {

    private HrmuserinfoService hrmuserinfoService;

    @Autowired
    public HrmuserinfoController(HrmuserinfoService record) {
        this.hrmuserinfoService = record;
    }


    @GetMapping("/insertSelective")
    public void insertSelective(Hrmuserinfo record) {
        this.hrmuserinfoService.insertSelective();
    }

    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS, this.hrmuserinfoService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<Hrmuserinfo> findByQuery(Hrmuserinfo record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Hrmuserinfo>(this.hrmuserinfoService.findByQuery(record));

    }
}

