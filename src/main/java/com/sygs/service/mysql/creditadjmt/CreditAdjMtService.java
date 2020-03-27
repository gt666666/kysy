package com.sygs.service.mysql.creditadjmt;

import cn.hutool.core.date.DateTime;
import com.sygs.dao.mysql.creditadjdt.CreditAdjDtMapper;
import com.sygs.dao.sqlserver.creditadjdt.CreditAdjDtSqlMapper;
import com.sygs.dao.sqlserver.creditadjmt.CreditAdjMtSqlMapper;
import com.sygs.pojo.mysql.creditadjdt.CreditAdjDt;
import com.sygs.pojo.sqlserver.creditadjmt.CreditAdjMtSql;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sygs.config.global.FailException;
import com.sygs.enums.LogInfoTypeEnum;
import com.sygs.enums.ResultEnum;
import com.sygs.enums.TableNameEnum;
import com.sygs.service.loginfo.LogInfoService;
import com.sygs.utils.Tools;
import com.sygs.dao.mysql.creditadjmt.CreditAdjMtMapper;
import com.sygs.pojo.mysql.creditadjmt.CreditAdjMt;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 信贷申请主表
 *
 * @author gaoting
 */
@WebService
@Service
public class CreditAdjMtService {
    @Resource
    private CreditAdjMtMapper creditAdjMtMapper;
    @Resource
    private CreditAdjDtMapper creditAdjDtMapper;
    @Resource
    private  CreditAdjMtSqlMapper creditAdjMtSqlMapper;
    @Resource
    private CreditAdjDtSqlMapper  creditAdjDtSqlMapper;

    public void CreditAdjMtService(){

    }

    /**
         * <p> 方法描述：添加记录（要修改xml对应的方法，让其返回添加记录的id）. </p>
         * <p> 创建时间：2020-03-13 09:47:29 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ,entid记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public void insertSelective(Integer billno, String  entid) {
            Map<String,Object>   map=new HashMap<>();
            map.put("billno",billno);
             map.put("entid",entid);
            CreditAdjMt creditAdjMt = this.creditAdjMtSqlMapper.ViewOaCreditAdjMt(map);
            creditAdjMt.setCreateDate(new DateTime());
            creditAdjMt.setIsDelete(false);
            creditAdjMt.setStatus(false);
            this.creditAdjMtMapper.insertSelective(creditAdjMt);   //信贷申请主表插入
            List<CreditAdjDt> creditAdjDtList=this.creditAdjDtSqlMapper.ViewOaCreditAdjDt(map);
            for(CreditAdjDt   creditAdjDt:creditAdjDtList){
                creditAdjDt.setIsDelete(false);
                creditAdjDt.setStatus(false);
                creditAdjDt.setCreateDate(new Date());
            }
            this.creditAdjDtMapper.insertForeach(creditAdjDtList);   //信贷申请子表插入
        }

        /**
         * <p> 方法描述：通过记录id删除记录. </p>
         * <p> 创建时间：2020-03-13 09:47:29 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ,entid
         */
        @Transactional(rollbackFor = Exception.class)
        public int deleteById( Integer billno,String  entid) {
             CreditAdjMt record =this.selectById(billno,entid);
                if (null == record) {
                throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return  this.creditAdjMtMapper.deleteByPrimaryKey(billno,entid);
        }

        /**
         * <p> 方法描述：更新记录. </p>
         * <p> 创建时间：2020-03-13 09:47:29 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public int updateById(CreditAdjMt record) {
            // 先查询，再次修改。记录必须有id才能修改
            if (Tools.isBlank(record.getBillno())|| Tools.isBlank(record.getBillno())) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
            }
             // 未查询到记录的不能修改
             CreditAdjMt select = this.selectById(record.getBillno(),record.getEntid());
             if (null == select) {
             throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return this.creditAdjMtMapper.updateByPrimaryKeySelective(record);
        }

        /**
         * <p> 方法描述：根据记录id查询记录. </p>
         * <p> 创建时间：2020-03-13 09:47:29 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ，entid
         */
        public CreditAdjMt selectById( Integer billno,String  entid) {
            return this.creditAdjMtMapper.selectByPrimaryKey(billno,entid);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出单条记录. </p>
         * <p> 创建时间：2020-03-13 09:47:29 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public CreditAdjMt find(CreditAdjMt record) {
             return this.creditAdjMtMapper.find(record);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出列表记录. </p>
         * <p> 创建时间：2020-03-13 09:47:29 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param
         */
        public List<CreditAdjMt> list() {
            CreditAdjMt  creditAdjMt=new CreditAdjMt();
            creditAdjMt.setStatus(false);
            List<CreditAdjMt> creditAdjMtList = this.creditAdjMtMapper.list(creditAdjMt);
            CreditAdjDt  creditAdjDt=null;
            for(CreditAdjMt    creditAdjMt1:creditAdjMtList){
                         creditAdjDt=new CreditAdjDt();
                         creditAdjDt.setStatus(false);
                         creditAdjDt.setBillno(creditAdjMt1.getBillno());
                         creditAdjDt.setEntid(creditAdjMt1.getEntid());
                List<CreditAdjDt> creditAdjDtList = this.creditAdjDtMapper.list(creditAdjDt);
                creditAdjMt1.setCreditAdjDts(creditAdjDtList);
            }
             return creditAdjMtList;
        }

        /**
         * <p> 方法描述：根据 查询对象 分页查询数据. </p>
         * <p> 创建时间：2020-03-13 09:47:29 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public List<CreditAdjMt> findByQuery(CreditAdjMt record) {

             return  this.creditAdjMtMapper.list(record);
        }

}
