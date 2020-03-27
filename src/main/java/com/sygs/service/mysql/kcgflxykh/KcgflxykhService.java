package com.sygs.service.mysql.kcgflxykh;

import cn.hutool.core.date.DateTime;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sygs.config.global.FailException;
import com.sygs.enums.LogInfoTypeEnum;
import com.sygs.enums.ResultEnum;
import com.sygs.enums.TableNameEnum;
import com.sygs.service.loginfo.LogInfoService;
import com.sygs.utils.Tools;
import com.sygs.dao.mysql.kcgflxykh.KcgflxykhMapper;
import com.sygs.pojo.mysql.kcgflxykh.Kcgflxykh;
import java.util.List;

/**
 * 采购返利子表
 *
 * @author gaoting
 */
@Service
public class KcgflxykhService {
    private KcgflxykhMapper kcgflxykhMapper;

        @Autowired
        public KcgflxykhService(KcgflxykhMapper kcgflxykhMapper) {

            this.kcgflxykhMapper = kcgflxykhMapper;
        }

        /**
         * <p> 方法描述：添加记录（要修改xml对应的方法，让其返回添加记录的id）. </p>
         * <p> 创建时间：2020-03-23 11:01:59 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public void insertSelective(Kcgflxykh record) {
            record.setCreateDate(new DateTime());
            record.setIsDelete(false);
            this.kcgflxykhMapper.insertSelective(record);

        }

        /**
         * <p> 方法描述：通过记录id删除记录. </p>
         * <p> 创建时间：2020-03-23 11:01:59 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ,entid
         */
        @Transactional(rollbackFor = Exception.class)
        public int deleteById( Integer billno,String  entid) {
             Kcgflxykh record =this.selectById(billno,entid);
                if (null == record) {
                throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return  this.kcgflxykhMapper.deleteByPrimaryKey(billno,entid);
        }

        /**
         * <p> 方法描述：更新记录. </p>
         * <p> 创建时间：2020-03-23 11:01:59 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public int updateById(Kcgflxykh record) {
            // 先查询，再次修改。记录必须有id才能修改
            if (Tools.isBlank(record.getBillno())|| Tools.isBlank(record.getBillno())) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
            }
             // 未查询到记录的不能修改
             Kcgflxykh select = this.selectById(record.getBillno(),record.getEntid());
             if (null == select) {
             throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return this.kcgflxykhMapper.updateByPrimaryKeySelective(record);
        }

        /**
         * <p> 方法描述：根据记录id查询记录. </p>
         * <p> 创建时间：2020-03-23 11:01:59 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ，entid
         */
        public Kcgflxykh selectById( Integer billno,String  entid) {
            return this.kcgflxykhMapper.selectByPrimaryKey(billno,entid);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出单条记录. </p>
         * <p> 创建时间：2020-03-23 11:01:59 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public Kcgflxykh find(Kcgflxykh record) {
             return this.kcgflxykhMapper.find(record);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出列表记录. </p>
         * <p> 创建时间：2020-03-23 11:01:59 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public List<Kcgflxykh> list(Kcgflxykh record) {
                return this.kcgflxykhMapper.list(record);
         }

        /**
         * <p> 方法描述：根据 查询对象 分页查询数据. </p>
         * <p> 创建时间：2020-03-23 11:01:59 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public List<Kcgflxykh> findByQuery(Kcgflxykh record) {

             return  this.kcgflxykhMapper.list(record);
        }

}
