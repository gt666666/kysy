package com.sygs.service.mysql.salenotesdt;

import cn.hutool.core.date.DateTime;
import com.sygs.utils.Tools;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sygs.config.global.FailException;
import com.sygs.enums.ResultEnum;
import com.sygs.dao.mysql.salenotesdt.SaleNotesDtMapper;
import com.sygs.pojo.mysql.salenotesdt.SaleNotesDt;

import java.util.List;

/**
 * 销售调价开票单
 *
 * @author gaoting
 */
@Service
public class SaleNotesDtService {
    private SaleNotesDtMapper saleNotesDtMapper;

        @Autowired
        public SaleNotesDtService(SaleNotesDtMapper saleNotesDtMapper) {

            this.saleNotesDtMapper = saleNotesDtMapper;
        }


        /**
         * <p> 方法描述：添加记录（要修改xml对应的方法，让其返回添加记录的id）. </p>
         * <p> 创建时间：2020-03-04 18:05:49 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public void insertSelective(SaleNotesDt record) {
            record.setCreateDate(new DateTime());
            record.setIsDelete(false);
            this.saleNotesDtMapper.insertSelective(record);
        }

        /**
         * <p> 方法描述：通过记录id删除记录. </p>
         * <p> 创建时间：2020-03-04 18:05:49 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ,entid
         */
        @Transactional(rollbackFor = Exception.class)
        public int deleteById( String billno,String  entid,String billsn) {
             SaleNotesDt record =this.selectById(billno,entid);
                if (null == record) {
                throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return  this.saleNotesDtMapper.deleteByPrimaryKey(billno,entid,billsn);
        }

        /**
         * <p> 方法描述：更新记录. </p>
         * <p> 创建时间：2020-03-04 18:05:49 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public int updateById(SaleNotesDt record) {
            // 先查询，再次修改。记录必须有id才能修改
            if (Tools.isBlank(record.getBillno())|| Tools.isBlank(record.getEntid())) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
            }
             // 未查询到记录的不能修改
             List<SaleNotesDt> select = this.list(record);
             if (null == select) {
             throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return this.saleNotesDtMapper.updateByPrimaryKeySelective(record);
        }

        /**
         * <p> 方法描述：根据记录id查询记录. </p>
         * <p> 创建时间：2020-03-04 18:05:49 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ，entid
         */
        public SaleNotesDt selectById( String billno,String  entid) {
            System.err.println(billno+"   "+entid  );
            return this.saleNotesDtMapper.selectByPrimaryKey(billno,entid);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出单条记录. </p>
         * <p> 创建时间：2020-03-04 18:05:49 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public SaleNotesDt find(SaleNotesDt record) {
             return this.saleNotesDtMapper.find(record);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出列表记录. </p>
         * <p> 创建时间：2020-03-04 18:05:49 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public List<SaleNotesDt> list(SaleNotesDt record) {
                return this.saleNotesDtMapper.list(record);
         }

        /**
         * <p> 方法描述：根据 查询对象 分页查询数据. </p>
         * <p> 创建时间：2020-03-04 18:05:49 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public List<SaleNotesDt> findByQuery(SaleNotesDt record) {

             return  this.saleNotesDtMapper.list(record);
        }

}
