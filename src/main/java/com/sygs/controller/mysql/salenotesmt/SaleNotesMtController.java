package com.sygs.controller.mysql.salenotesmt;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.sygs.controller.abs.AbstractBaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sygs.enums.ResultEnum ;
import com.sygs.utils.Page;
import com.github.pagehelper.PageHelper;
import com.sygs.utils.PaginationContext;
import com.sygs.pojo.CommonResult;
import com.sygs.pojo.mysql.salenotesmt.SaleNotesMt;
import com.sygs.service.mysql.salenotesmt.SaleNotesMtService;

import javax.servlet.http.HttpServletRequest;

/**
 * 销售调价开票单主表
 *
 * @author gaoting
 * @date：2020-03-04 17:51:12
 */
@RestController
@RequestMapping(value = "/salenotesmt",produces = MediaType.APPLICATION_JSON_VALUE)
public class SaleNotesMtController extends AbstractBaseController {

    private SaleNotesMtService saleNotesMtService=new SaleNotesMtService();


    @PostMapping("/insertSelective")
    public String insertSelective(String  billno,String  entid, HttpServletRequest request) {
        String jsonpcallback = request.getParameter("jsonpcallback") ;
        this.saleNotesMtService.insertSelective(billno,entid);
        return jsonpcallback + "({\"billno\":\"" + billno + "\",\"entid\":\"" + entid + "\"})";
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( String billno,String  entid) {
        int i=this.saleNotesMtService.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(SaleNotesMt record) {
        int i= this.saleNotesMtService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( String billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.saleNotesMtService.selectById(billno,entid));
    }


    @GetMapping("/listAllByStatus")
    public CommonResult listAllByStatus( ){
        return resultData(ResultEnum.SELECT_SUCCESS,this.saleNotesMtService.list());
    }

    @GetMapping("/findByQuery")
    public Page<SaleNotesMt> findByQuery(SaleNotesMt record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<SaleNotesMt>(this.saleNotesMtService.findByQuery(record));

    }
}

