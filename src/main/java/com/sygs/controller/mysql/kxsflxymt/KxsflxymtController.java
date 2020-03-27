package com.sygs.controller.mysql.kxsflxymt;

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
import com.sygs.pojo.mysql.kxsflxymt.Kxsflxymt;
import com.sygs.service.mysql.kxsflxymt.KxsflxymtService;

import javax.servlet.http.HttpServletRequest;

/**
 * 销售返利协议主表
 *
 * @author gaoting
 * @date：2020-03-20 15:42:30
 */
@RestController
@RequestMapping("/kxsflxymt")
public class KxsflxymtController extends AbstractBaseController {

    private KxsflxymtService kxsflxymtService;
    @Autowired
    public KxsflxymtController(KxsflxymtService record) {
        this.kxsflxymtService = record;
    }


    @PostMapping("/insertSelective")
    public String insertSelective(Integer billno, String  entid, HttpServletRequest request) {
        String jsonpcallback = request.getParameter("jsonpcallback") ;
        this.kxsflxymtService.insertSelective(billno,entid);
        return jsonpcallback + "({\"billno\":\"" + billno + "\",\"entid\":\"" + entid + "\"})";
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kxsflxymtService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(Kxsflxymt record) {
        int i= this.kxsflxymtService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kxsflxymtService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kxsflxymtService.list());
    }

    @GetMapping("/findByQuery")
    public Page<Kxsflxymt> findByQuery(Kxsflxymt record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Kxsflxymt>(this.kxsflxymtService.findByQuery(record));

    }
}

