package com.sygs.controller.mysql.kplfkmt;

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
import com.sygs.pojo.mysql.kplfkmt.KPlfkmt;
import com.sygs.service.mysql.kplfkmt.KPlfkmtService;

import javax.servlet.http.HttpServletRequest;

/**
 * 正常付款批量主表
 *
 * @author gaoting
 * @date：2020-03-20 13:29:46
 */
@RestController
@RequestMapping("/kplfkmt")
public class KPlfkmtController extends AbstractBaseController {

    private KPlfkmtService kPlfkmtService;
    @Autowired
    public KPlfkmtController(KPlfkmtService record) {
        this.kPlfkmtService = record;
    }


    @PostMapping("/insertSelective")
    public String insertSelective(Integer billno, String  entid, HttpServletRequest request) {
        String jsonpcallback = request.getParameter("jsonpcallback") ;
        this.kPlfkmtService.insertSelective(billno,entid);
        return jsonpcallback + "({\"billno\":\"" + billno + "\",\"entid\":\"" + entid + "\"})";
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.kPlfkmtService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


//    @PostMapping("/updateById")
//    public CommonResult updateById(KPlfkmt record) {
//        int i= this.kPlfkmtService.updateById(record);
//        if (i==1) {
//        return result(ResultEnum.UPDATE_SUCCESS);
//        }
//        return  result(ResultEnum.UPDATE_ERROR);
//    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kPlfkmtService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.kPlfkmtService.listAll());
    }

    @GetMapping("/findByQuery")
    public Page<KPlfkmt> findByQuery(KPlfkmt record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<KPlfkmt>(this.kPlfkmtService.findByQuery(record));

    }
}

