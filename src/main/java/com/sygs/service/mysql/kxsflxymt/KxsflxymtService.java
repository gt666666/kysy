package com.sygs.service.mysql.kxsflxymt;

import cn.hutool.core.date.DateTime;
import com.sygs.dao.mysql.kxsflxydt.KxsflxydtMapper;
import com.sygs.dao.sqlserver.kxsflxydt.KxsflxydtSqlMapper;
import com.sygs.dao.sqlserver.kxsflxymt.KxsflxymtSqlMapper;
import com.sygs.pojo.mysql.kxsflxydt.Kxsflxydt;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sygs.config.global.FailException;
import com.sygs.enums.LogInfoTypeEnum;
import com.sygs.enums.ResultEnum;
import com.sygs.enums.TableNameEnum;
import com.sygs.service.loginfo.LogInfoService;
import com.sygs.utils.Tools;
import com.sygs.dao.mysql.kxsflxymt.KxsflxymtMapper;
import com.sygs.pojo.mysql.kxsflxymt.Kxsflxymt;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 销售返利协议主表
 *
 * @author gaoting
 */
@Service
@WebService
public class KxsflxymtService {

    @Resource
    private KxsflxymtMapper kxsflxymtMapper;
    @Resource
    private KxsflxymtSqlMapper kxsflxymtSqlMapper;
    @Resource
    private KxsflxydtSqlMapper  kxsflxydtSqlMapper;
    @Resource
    private KxsflxydtMapper  kxsflxydtMapper;

        /**
         * <p> 方法描述：添加记录（要修改xml对应的方法，让其返回添加记录的id）. </p>
         * <p> 创建时间：2020-03-20 15:42:30 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno, entid记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public void insertSelective(Integer billno, String  entid) {
            Map<String,Object> map=new HashMap<>();
            map.put("billno",billno);
            map.put("entid",entid);
            Kxsflxymt kxsflxymt = this.kxsflxymtSqlMapper.viewOaKxyflmt(map);
            kxsflxymt.setCreateDate(new DateTime());
            kxsflxymt.setIsDelete(false);
            kxsflxymt.setStatus(false);
            this.kxsflxymtMapper.insertSelective(kxsflxymt);  //销售返利协议主表插入
            List<Kxsflxydt> kxsflxydtList=this.kxsflxydtSqlMapper.viewOaKxyfldt(map);
            for(Kxsflxydt  kxsflxydt:kxsflxydtList){
                kxsflxydt.setCreateDate(new DateTime());
                kxsflxydt.setIsDelete(false);
                kxsflxydt.setStatus(false);
            }
                  this.kxsflxydtMapper.insertForeach(kxsflxydtList);   //销售返利协议子表插入
        }

        /**
         * <p> 方法描述：通过记录id删除记录. </p>
         * <p> 创建时间：2020-03-20 15:42:30 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ,entid
         */
        @Transactional(rollbackFor = Exception.class)
        public int deleteById( Integer billno,String  entid) {
             Kxsflxymt record =this.selectById(billno,entid);
                if (null == record) {
                throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return  this.kxsflxymtMapper.deleteByPrimaryKey(billno,entid);
        }

        /**
         * <p> 方法描述：更新记录. </p>
         * <p> 创建时间：2020-03-20 15:42:30 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 记录对象
         */
        @Transactional(rollbackFor = Exception.class)
        public int updateById(Kxsflxymt record) {
            // 先查询，再次修改。记录必须有id才能修改
            if (Tools.isBlank(record.getBillno())|| Tools.isBlank(record.getBillno())) {
            throw new FailException(ResultEnum.RECORD_IS_NULL);
            }
             // 未查询到记录的不能修改
             Kxsflxymt select = this.selectById(record.getBillno(),record.getEntid());
             if (null == select) {
             throw new FailException(ResultEnum.RECORD_IS_NULL);
             }
             return this.kxsflxymtMapper.updateByPrimaryKeySelective(record);
        }

        /**
         * <p> 方法描述：根据记录id查询记录. </p>
         * <p> 创建时间：2020-03-20 15:42:30 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param billno ，entid
         */
        public Kxsflxymt selectById( Integer billno,String  entid) {
            return this.kxsflxymtMapper.selectByPrimaryKey(billno,entid);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出单条记录. </p>
         * <p> 创建时间：2020-03-20 15:42:30 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public Kxsflxymt find(Kxsflxymt record) {
             return this.kxsflxymtMapper.find(record);
        }

        /**
         * <p> 方法描述：根据 查询对象 查询出列表记录. </p>
         * <p> 创建时间：2020-03-20 15:42:30 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param
         */
        public List<Kxsflxymt> list() {
            Kxsflxymt   kxsflxymt=new Kxsflxymt();
            kxsflxymt.setStatus(false);
            List<Kxsflxymt> kxsflxymtList = this.kxsflxymtMapper.list(kxsflxymt);
            Kxsflxydt   kxsflxydt=null;
            for(Kxsflxymt  kxsflxymt1:kxsflxymtList){
                       kxsflxydt=new Kxsflxydt();
                       kxsflxydt.setStatus(false);
                       kxsflxydt.setBillno(kxsflxymt1.getBillno());
                       kxsflxydt.setEntid(kxsflxymt1.getEntid());
                List<Kxsflxydt> kxsflxydtList= this.kxsflxydtMapper.list(kxsflxydt);
                kxsflxymt1.setKxsflxydts(kxsflxydtList);
            }
            return  kxsflxymtList;
         }

        /**
         * <p> 方法描述：根据 查询对象 分页查询数据. </p>
         * <p> 创建时间：2020-03-20 15:42:30 </p>
         * <p> 创建作者：gaoting </p>
         * <p> 修改作者： </p>
         *
         * @param record 查询对象
         */
        public List<Kxsflxymt> findByQuery(Kxsflxymt record) {

             return  this.kxsflxymtMapper.list(record);
        }

}
