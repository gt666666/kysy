package com.sygs.controller.mysql.mastername;

import com.sygs.service.mysql.detailname.DetailnameService;
import com.sygs.utils.RedisUtil;
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
import com.sygs.pojo.mysql.mastername.Mastername;
import com.sygs.service.mysql.mastername.MasternameService;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 *
 * @author gaoting
 * @date：2020-02-21 09:55:04
 */
@RestController
@RequestMapping(value ="/mastername",produces = MediaType.APPLICATION_JSON_VALUE)
public class MasternameController extends AbstractBaseController {

    @Autowired
    private RedisUtil redisUtil;
   @Autowired
    private DetailnameService detailnameService;
    private MasternameService masternameService;
    @Autowired
    public MasternameController(MasternameService record) {
        this.masternameService = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective( @RequestBody Mastername record,HttpServletRequest  request){
        String name = redisUtil.getName(request);
        record.setMemberName(name);  //设置管理员姓名
        Long i = this.masternameService.insertSelective(record);   //返回主表主键id

        if(i>0){
            return result(ResultEnum.INSERT_SUCCESS);
        }
        return result(ResultEnum.INSERT_ERROR);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Long mid) {
        int i=this.masternameService.deleteById(mid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById(@RequestBody Mastername record) {
        System.err.println(record);
        record.setUpdateDate(new Date());  //最后一次修改时间
        int i= this.masternameService.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Long mid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.masternameService.selectById(mid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.masternameService.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<Mastername> findByQuery(Mastername record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        record.setIsDelete(false);
        return new Page<Mastername>(this.masternameService.findByQuery(record));

    }
}

