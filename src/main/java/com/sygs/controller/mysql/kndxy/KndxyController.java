package com.sygs.controller.mysql.kndxy;

import org.springframework.web.bind.annotation.*;
import com.sygs.controller.abs.AbstractBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sygs.enums.ResultEnum ;
import com.sygs.utils.Page;
import com.github.pagehelper.PageHelper;
import com.sygs.utils.PaginationContext;
import com.sygs.pojo.CommonResult;
import com.sygs.pojo.mysql.kndxy.Kndxy;
import com.sygs.service.mysql.kndxy.KndxyService;

import javax.servlet.http.HttpServletRequest;

/**
 * 销售年度协议
 *
 * @author gaoting
 * @date：2020-03-23 08:52:11
 */
@RestController
@RequestMapping("/kndxy")
public class KndxyController extends AbstractBaseController {

    private KndxyService kndxyService;
    @Autowired
    public KndxyController(KndxyService record) {
        this.kndxyService = record;
    }


    @PostMapping("/insertSelective")
    public String insertSelective(Integer billno, String  entid, HttpServletRequest request) {
        String jsonpcallback = request.getParameter("jsonpcallback") ;
        this.kndxyService.insertSelective(billno,entid);
        return jsonpcallback + "({\"billno\":\"" + billno + "\",\"entid\":\"" + entid + "\"})";
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kndxyService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(Kndxy record) {
        int i= this.kndxyService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kndxyService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kndxyService.list());
    }

    @GetMapping("/findByQuery")
    public Page<Kndxy> findByQuery(Kndxy record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Kndxy>(this.kndxyService.findByQuery(record));

    }
}

