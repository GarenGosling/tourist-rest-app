package org.garen.tourist.swagger.api.valid;

import org.apache.commons.lang3.StringUtils;
import org.garen.tourist.swagger.model.Apply;
import org.springframework.stereotype.Component;

/**
 * 报名申请参数验证类
 *
 * @author yanglimou
 * @create 2017/10/30 21:30
 * @since v1.0
 */
@Component
public class ApplyValid {
    /**
     * 保存验证
     * @param apply
     * @return
     */
    public String saveApplyValid(Apply apply) {
        if(StringUtils.isBlank(apply.getItemName()))
            return "项目名为空";
        if(StringUtils.isBlank(apply.getName()))
            return  "姓名为空";
        if(StringUtils.isBlank(apply.getPhone()))
            return "手机号为空";
        if(!apply.getPhone().matches("^[0-9]{11}$"))
            return "手机号只能是11位数字";
        if(StringUtils.isBlank(apply.getSex()))
            return "性别为空";
        if(!apply.getSex().equals("男")&&!apply.getSex().equals("女"))
            return "性别只能是男或者女";
        return null;
    }

    /**
     * 修改验证
     * @param apply
     * @return
     */
    public String updateApplyValid(Apply apply) {
        return saveApplyValid(apply);
    }
}
