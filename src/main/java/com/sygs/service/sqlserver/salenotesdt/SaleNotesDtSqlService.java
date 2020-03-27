package com.sygs.service.sqlserver.salenotesdt;

import cn.hutool.core.date.DateTime;
import com.sygs.dao.sqlserver.salenotesdt.SaleNotesDtSqlMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sygs.config.global.FailException;
import com.sygs.enums.ResultEnum;
import com.sygs.utils.Tools;
import com.sygs.pojo.sqlserver.salenotesdt.SaleNotesDtSql;
import java.util.List;

/**
 * 销售调价开票单
 *
 * @author gaoting
 */
@Service
public class SaleNotesDtSqlService {


       private SaleNotesDtSqlMapper saleNotesDtSqlMapper;

        @Autowired
        public SaleNotesDtSqlService(SaleNotesDtSqlMapper saleNotesDtSqlMapper) {

            this.saleNotesDtSqlMapper = saleNotesDtSqlMapper;
        }

        /**
         * <p> 方法描述：添加记录（要修改xml对应的方法，让其返回添加记录的id）. </p>
         * <p> 创建时间：2020-03-09 17:22:57 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public void insertSelective(SaleNotesDtSql record) {
            record.setCreateDate(new DateTime());
            record.setIsDelete(false);
            this.saleNotesDtSqlMapper.insertSelective(record);

        }

        /**
         * <p> 方法描述：通过记录id删除记录. </p>
         * <p> 创建时间：2020-03-09 17:22:57 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ,entid
         */
        @Transactional(rollbackFor = Exception.class)
        public int deleteById( String billno,String  entid,String  billsn) {
             SaleNotesDtSql record =this.selectById(billno,entid,billsn);
                if (null == record) {
                throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return  this.saleNotesDtSqlMapper.deleteByPrimaryKey(billno,entid,billsn);
        }

        /**
         * <p> 方法描述：更新记录. </p>
         * <p> 创建时间：2020-03-09 17:22:57 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public int updateById(SaleNotesDtSql record) {
            // 先查询，再次修改。记录必须有id才能修改
            if (Tools.isBlank(record.getBillno())|| Tools.isBlank(record.getBillno())) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
            }
             // 未查询到记录的不能修改
             SaleNotesDtSql select = this.selectById(record.getBillno(),record.getEntid(),record.getBillsn());
             if (null == select) {
             throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return this.saleNotesDtSqlMapper.updateByPrimaryKeySelective(record);
        }

        /**
         * <p> 方法描述：根据记录id查询记录. </p>
         * <p> 创建时间：2020-03-09 17:22:57 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ，entid
         */
        public SaleNotesDtSql selectById( String billno,String  entid,String  billsn) {
            return this.saleNotesDtSqlMapper.selectByPrimaryKey(billno,entid,billsn);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出单条记录. </p>
         * <p> 创建时间：2020-03-09 17:22:57 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public SaleNotesDtSql find(SaleNotesDtSql record) {
             return this.saleNotesDtSqlMapper.find(record);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出列表记录. </p>
         * <p> 创建时间：2020-03-09 17:22:57 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public List<SaleNotesDtSql> list(SaleNotesDtSql record) {
                return this.saleNotesDtSqlMapper.list(record);
         }

        /**
         * <p> 方法描述：根据 查询对象 分页查询数据. </p>
         * <p> 创建时间：2020-03-09 17:22:57 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public List<SaleNotesDtSql> findByQuery(SaleNotesDtSql record) {

             return  this.saleNotesDtSqlMapper.list(record);
        }

}
