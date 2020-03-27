package com.sygs.controller.mysql.salenotesdt;

import org.springframework.http.MediaType;
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
import com.sygs.pojo.mysql.salenotesdt.SaleNotesDt;
import com.sygs.service.mysql.salenotesdt.SaleNotesDtService;
/**
 * 销售调价开票单
 *
 * @author gaoting
 * @date：2020-03-04 18:05:49
 */
@RestController
@RequestMapping(value = "/salenotesdt",produces = MediaType.APPLICATION_JSON_VALUE)
public class SaleNotesDtController extends AbstractBaseController {

    private SaleNotesDtService saleNotesDtService;
    @Autowired
    public SaleNotesDtController(SaleNotesDtService record) {
        this.saleNotesDtService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(SaleNotesDt record) {
        this.saleNotesDtService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( String billno,String  entid,String billsn) {
        int i=this.saleNotesDtService.deleteById(billno,entid,billsn);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(SaleNotesDt record) {
        int i= this.saleNotesDtService.updateById(record);
        if (i!=0) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( String billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.saleNotesDtService.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll(SaleNotesDt record) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.saleNotesDtService.list(record));
    }

    @GetMapping("/findByQuery")
    public Page<SaleNotesDt> findByQuery(SaleNotesDt record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<SaleNotesDt>(this.saleNotesDtService.findByQuery(record));

    }
}

