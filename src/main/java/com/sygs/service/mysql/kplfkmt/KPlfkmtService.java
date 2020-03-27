package com.sygs.service.mysql.kplfkmt;

import cn.hutool.core.date.DateTime;
import com.sygs.dao.mysql.kfkpldt.KfkpldtMapper;

import com.sygs.dao.sqlserver.kfkpldt.KfkpldtSqlMapper;
import com.sygs.dao.sqlserver.kplfkmt.KPlfkmtSqlMapper;
import com.sygs.pojo.mysql.creditadjdt.CreditAdjDt;
import com.sygs.pojo.mysql.creditadjmt.CreditAdjMt;
import com.sygs.pojo.mysql.kfkpldt.Kfkpldt;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sygs.config.global.FailException;
import com.sygs.enums.LogInfoTypeEnum;
import com.sygs.enums.ResultEnum;
import com.sygs.enums.TableNameEnum;
import com.sygs.service.loginfo.LogInfoService;
import com.sygs.utils.Tools;
import com.sygs.dao.mysql.kplfkmt.KPlfkmtMapper;
import com.sygs.pojo.mysql.kplfkmt.KPlfkmt;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 正常付款批量主表
 *
 * @author gaoting
 */
@Service
@WebService
public class KPlfkmtService {
    @Resource
    private KPlfkmtMapper kPlfkmtMapper;
    @Resource
    private KPlfkmtSqlMapper kPlfkmtSqlMapper;
    @Resource
    private
    KfkpldtSqlMapper kfkpldtSqlMapper;
    @Resource
    private KfkpldtMapper kfkpldtMapper;

   public KPlfkmtService(){

   }

        /**
         * <p> 方法描述：添加记录（要修改xml对应的方法，让其返回添加记录的id）. </p>
         * <p> 创建时间：2020-03-20 13:29:46 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno, entid记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public void insertSelective(Integer billno, String  entid) {
            Map<String, Object> map = new HashMap<>();
            map.put("billno", billno);
            map.put("entid", entid);
            KPlfkmt kPlfkmt = this.kPlfkmtSqlMapper.viewOaKplfkmt(map);
            kPlfkmt.setCreateDate(new DateTime());
            kPlfkmt.setIsDelete(false);
            kPlfkmt.setStatus(false);
            this.kPlfkmtMapper.insertSelective(kPlfkmt);   //正常付款申请单批量主表插入
            List<Kfkpldt> kPlfkmtList = this.kfkpldtSqlMapper.viewOaKfkpldt(map);
            for(Kfkpldt kfkpldt:kPlfkmtList){
                kfkpldt.setIsDelete(false);
                kfkpldt.setStatus(false);
                kfkpldt.setCreateDate(new Date());
            }
            this.kfkpldtMapper.insertForeach(kPlfkmtList);  //正常付款申请单批量子表插入

        }

        /**
         * <p> 方法描述：通过记录id删除记录. </p>
         * <p> 创建时间：2020-03-20 13:29:46 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ,entid
         */
        @Transactional(rollbackFor = Exception.class)
        public int deleteById( Integer billno,String  entid) {
             KPlfkmt record =this.selectById(billno,entid);
                if (null == record) {
                throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return  this.kPlfkmtMapper.deleteByPrimaryKey(billno,entid);
        }

        /**
         * <p> 方法描述：更新记录. </p>
         * <p> 创建时间：2020-03-20 13:29:46 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public int updateById(KPlfkmt record) {
            // 先查询，再次修改。记录必须有id才能修改
            if (Tools.isBlank(record.getBillno())|| Tools.isBlank(record.getBillno())) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
            }
             // 未查询到记录的不能修改
             KPlfkmt select = this.selectById(record.getBillno(),record.getEntid());
             if (null == select) {
             throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return this.kPlfkmtMapper.updateByPrimaryKeySelective(record);
        }

        /**
         * <p> 方法描述：根据记录id查询记录. </p>
         * <p> 创建时间：2020-03-20 13:29:46 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ，entid
         */
        public KPlfkmt selectById( Integer billno,String  entid) {
            return this.kPlfkmtMapper.selectByPrimaryKey(billno,entid);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出单条记录. </p>
         * <p> 创建时间：2020-03-20 13:29:46 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public KPlfkmt find(KPlfkmt record) {
             return this.kPlfkmtMapper.find(record);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出列表记录. </p>
         * <p> 创建时间：2020-03-20 13:29:46 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public List<KPlfkmt> list() {
            KPlfkmt  kPlfkmt=new KPlfkmt();
            kPlfkmt.setStatus(false);
            List<KPlfkmt> kPlfkmtList = this.kPlfkmtMapper.list(kPlfkmt);
            Kfkpldt  kfkpldt=null;
            for(KPlfkmt kPlfkmt1:kPlfkmtList){
                kfkpldt=new Kfkpldt();
                kfkpldt.setStatus(false);
                kfkpldt.setBillno(kPlfkmt1.getBillno());
                kfkpldt.setEntid(kPlfkmt1.getEntid());
                List<Kfkpldt> kfkpldtList = this.kfkpldtMapper.list(kfkpldt);
                kPlfkmt1.setKfkpldts(kfkpldtList);
            }
            return kPlfkmtList;
         }

        /**
         * <p> 方法描述：根据 查询对象 分页查询数据. </p>
         * <p> 创建时间：2020-03-20 13:29:46 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public List<KPlfkmt> findByQuery(KPlfkmt record) {

             return  this.kPlfkmtMapper.list(record);
        }

}
