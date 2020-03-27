package com.sygs.controller.mysql.detailname;

import com.sygs.utils.RedisUtil;
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
import com.sygs.pojo.mysql.detailname.Detailname;
import com.sygs.service.mysql.detailname.DetailnameService;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 
 *
 * @author gaoting
 * @date：2020-02-22 21:05:38
 */
@RestController
@RequestMapping("/detailname")
public class DetailnameController extends AbstractBaseController {

    @Autowired
    private RedisUtil redisUtil;
    private DetailnameService detailnameService;
    @Autowired
    public DetailnameController(DetailnameService record) {
        this.detailnameService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective(@RequestBody Detailname record, HttpServletRequest request) {
        String name = redisUtil.getName(request);
        record.setMemberName(name);  //设置管理员姓名
        this.detailnameService.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Long id) {
        int i=this.detailnameService.deleteById(id);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(@RequestBody Detailname record) {
        record.setUpdateDate(new Date());  //最后一次修改时间
        int i= this.detailnameService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Long id) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.detailnameService.selectById(id));
    }


    @GetMapping("/listAll")
    public CommonResult listAll(Long  mid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.detailnameService.list(mid));
    }

    @GetMapping("/findByQuery")
    public Page<Detailname> findByQuery(Detailname record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<Detailname>(this.detailnameService.findByQuery(record));

    }
}

