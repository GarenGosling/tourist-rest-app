package org.garen.tourist.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.garen.tourist.mybatis.domain.Apply;
import org.garen.tourist.mybatis.domain.ApplyExample;
import org.garen.tourist.mybatis.service.ApplyService;
import org.garen.tourist.mybatis.service.CommonsService;
import org.garen.tourist.util.EsapiUtil;
import org.garen.tourist.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报名申请业务类
 *
 * @author yanglimou
 * @create 2017/10/30 21:25
 * @since v1.0
 */
@Service
public class ApplyManage extends  BaseManage<Long> {
    @Autowired
    private ApplyService<Apply,ApplyExample,Long> applyService;
    @Override
    public ApplyService<Apply,ApplyExample,Long> getService() {
        return applyService;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    public int deleteApply(Long id) {
        return  removeById(id);
    }

    /**
     * 查询全部
     * @return
     */
    public List<Apply> getAll() {
        return findAll();
    }
    /**
     * id查询
     */
    public Apply getApply(Long id) {
        return  getService().findByID(id);
    }

    /**
     * 分页查询
     * @param itemName
     * @param start
     * @param length
     * @return
     */
    public Map findByPage(String itemName, Integer start, Integer length) {
        //初始化参数
        if (start == null) start = 0;
        if (length == null) length = 10;
        ApplyExample applyExample=new ApplyExample();
        ApplyExample.Criteria criteria=applyExample.createCriteria();
        if(StringUtils.isNotBlank(itemName))
            criteria.andItemNameEqualTo(EsapiUtil.sql(itemName));
        List<Apply> applies=getService().findBy(new RowBounds(start,length),applyExample);
        //查询统计个数
        String sql = "select count(*) count from apply where 1=1 ";
        if(StringUtils.isNotBlank(itemName))
            sql+=" and item_name = '"+itemName+"'";
        int count=getService().countBySQL(sql);
        Map map=new HashMap();
        map.put("list", applies);
        map.put("count", count);
        return map;
    }

    /**
     * 手机号查询
     * @param phone
     * @return
     */
    public List<Apply> getByPhone(String phone) {
        ApplyExample applyExample=new ApplyExample();
        ApplyExample.Criteria criteria=applyExample.createCriteria();
        criteria.andPhoneEqualTo(EsapiUtil.sql(phone));
        return findListBy(applyExample);

    }

    /**
     * 保存
     * @param apply
     * @return
     */
    public int saveApply(org.garen.tourist.swagger.model.Apply apply) {
        Apply apply1=tranfer(apply);
        // TODO 用户码应该是从后台获取
        apply1.setUserCode("USER-15087800456568cb435b1526118");
        return create(apply1);
    }

    /**
     * 修改
     * @param apply
     * @return
     */
    public int updateApply(Long id,org.garen.tourist.swagger.model.Apply apply) {
        Apply apply1=tranfer(apply);
        apply1.setId(id);
        return modify(apply1);
    }

    /**
     * 实体类与参数类的转换工具
     *
     * @param apply
     * @return
     */
    private Apply tranfer(org.garen.tourist.swagger.model.Apply apply) {
        Apply apply1 = new Apply();
        TransferUtil.transfer(apply1, apply);
        return apply1;
    }
}
