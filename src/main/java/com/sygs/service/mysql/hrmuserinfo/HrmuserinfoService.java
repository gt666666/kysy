package com.sygs.service.mysql.hrmuserinfo;

import cn.hutool.core.date.DateTime;
import oaHrClient.ArrayOfUserBean;
import oaHrClient.HrmService;
import oaHrClient.HrmServicePortType;
import oaHrClient.UserBean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sygs.config.global.FailException;
import com.sygs.enums.LogInfoTypeEnum;
import com.sygs.enums.ResultEnum;
import com.sygs.enums.TableNameEnum;
import com.sygs.service.loginfo.LogInfoService;
import com.sygs.utils.Tools;
import com.sygs.dao.mysql.hrmuserinfo.HrmuserinfoMapper;
import com.sygs.pojo.mysql.hrmuserinfo.Hrmuserinfo;

import java.util.List;

/**
 * 人力资源员工信息
 *
 * @author gaoting
 */
@Service
public class HrmuserinfoService {
    private HrmuserinfoMapper hrmuserinfoMapper;

    @Autowired
    public HrmuserinfoService(HrmuserinfoMapper hrmuserinfoMapper) {

        this.hrmuserinfoMapper = hrmuserinfoMapper;
    }

    @Scheduled(cron = "0 00 23 * * ?")
    @Transactional
    public void insertSelective() {
        Hrmuserinfo hrmuserinfo=new Hrmuserinfo();
        this.hrmuserinfoMapper.deleteAll();//删除全部数据
        HrmService hrmService= new HrmService();
        HrmServicePortType hrmServiceHttpPort = hrmService.getHrmServiceHttpPort();
        ArrayOfUserBean hrmUserInfo = hrmServiceHttpPort.getHrmUserInfo("116.249.242.169", "", "1012", "", "", "");
        List<UserBean> userBeans = hrmUserInfo.getUserBean();
        System.err.println("总数"+userBeans.size());
        for(UserBean  userBean:userBeans  ){ //插入全部数据
            hrmuserinfo.setId(userBean.getUserid().intValue());
            hrmuserinfo.setLastname(userBean.getLastname().getValue());
            hrmuserinfo.setLoginid(userBean.getLoginid().getValue());
            hrmuserinfo.setDepartmentid(userBean.getDepartmentid().getValue());
            hrmuserinfo.setJobtitle(userBean.getJobtitle().getValue());
            this.hrmuserinfoMapper.insertSelective(hrmuserinfo);
        }
    }

    /**
     * <p> 方法描述：根据 查询对象 查询出单条记录. </p>
     * <p> 创建时间：2020-04-14 10:36:06 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 查询对象
     */
    public Hrmuserinfo find(Hrmuserinfo record) {
        return this.hrmuserinfoMapper.find(record);
    }

    /**
     * <p> 方法描述：根据 查询对象 查询出列表记录. </p>
     * <p> 创建时间：2020-04-14 10:36:06 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 查询对象
     */
    public List<Hrmuserinfo> list(Hrmuserinfo record) {
        return this.hrmuserinfoMapper.list(record);
    }

    /**
     * <p> 方法描述：根据 查询对象 分页查询数据. </p>
     * <p> 创建时间：2020-04-14 10:36:06 </p>
     * <p> 创建作者：gaoting </p>
     * <p> 修改作者： </p>
     *
     * @param record 查询对象
     */
    public List<Hrmuserinfo> findByQuery(Hrmuserinfo record) {

        return this.hrmuserinfoMapper.list(record);
    }

}
