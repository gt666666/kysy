package {{@controllerPackagePath@}};

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
import {{@pojoPath@}};
import {{@servicePackagePath@}}.{{@serviceName@}};
/**
 * {{@controllerTitle@}}
 *
 * @author {{@author@}}
 * @date：{{@date@}}
 */
@RestController
@RequestMapping("/{{@folderName@}}")
public class {{@controllerName@}} extends AbstractBaseController {

    private {{@serviceName@}} {{@serviceNameMin@}};
    @Autowired
    public {{@controllerName@}}({{@serviceName@}} record) {
        this.{{@serviceNameMin@}} = record;
    }


    @PostMapping("/insertSelective")
    public CommonResult insertSelective({{@pojoName@}} record) {
        this.{{@serviceNameMin@}}.insertSelective(record);
        return result(ResultEnum.INSERT_SUCCESS);
    }


    @PostMapping("/deleteById")
    public  CommonResult deleteById( Integer billno,String  entid) {
        int i=this.{{@serviceNameMin@}}.deleteById(billno,entid);
        if(i==1){
        return result(ResultEnum.DELETE_SUCCESS);
        }
        return  result(ResultEnum.DELETE_ERROR);
    }


    @PostMapping("/updateById")
    public CommonResult updateById({{@pojoName@}} record) {
        int i= this.{{@serviceNameMin@}}.updateById(record);
        if (i==1) {
        return result(ResultEnum.UPDATE_SUCCESS);
        }
        return  result(ResultEnum.UPDATE_ERROR);
    }


    @GetMapping("/selectById")
    public CommonResult selectById( Integer billno,String  entid) {
        return resultData(ResultEnum.SELECT_SUCCESS,this.{{@serviceNameMin@}}.selectById(billno,entid));
    }


    @GetMapping("/listAll")
    public CommonResult listAll() {
        return resultData(ResultEnum.SELECT_SUCCESS,this.{{@serviceNameMin@}}.list(null));
    }

    @GetMapping("/findByQuery")
    public Page<{{@pojoName@}}> findByQuery({{@pojoName@}} record) {
        PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
        return new Page<{{@pojoName@}}>(this.{{@serviceNameMin@}}.findByQuery(record));

    }
}

