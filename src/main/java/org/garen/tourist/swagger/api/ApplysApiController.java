package org.garen.tourist.swagger.api;

import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.garen.tourist.service.ApplyManage;
import org.garen.tourist.swagger.api.valid.ApplyValid;
import org.garen.tourist.swagger.model.Apply;
import org.garen.tourist.swagger.model.BaseModel;
import org.garen.tourist.swagger.model.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-30T13:16:24.540Z")

@Controller
public class ApplysApiController extends BaseModel implements ApplysApi {
    @Autowired
    private ApplyManage applyManage;
    @Autowired
    private ApplyValid applyValid;

    /**
     * 删除
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> deleteApply(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id) {
        int i=applyManage.deleteApply(id);
        return new ResponseEntity<ResponseModel>(successModel("删除成功，数量：" + i),HttpStatus.OK);
    }

    /**
     * 查询全部
     * @return
     */
    public ResponseEntity<ResponseModel> findAll() {
        List<org.garen.tourist.mybatis.domain.Apply> list=applyManage.getAll();
        return new ResponseEntity<ResponseModel>(successModel("查询全部").data(list),HttpStatus.OK);
    }

    /**
     * id查询
     * @param id
     * @return
     */
    public ResponseEntity<ResponseModel> getApply(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id) {
        org.garen.tourist.mybatis.domain.Apply apply=applyManage.getApply(id);
        return new ResponseEntity<ResponseModel>(successModel("id查询").data(apply),HttpStatus.OK);
    }

    /**
     * 分页查询
     * @param itemName
     * @param start
     * @param length
     * @return
     */
    public ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "项目名") @RequestParam(value = "itemName", required = false) String itemName,
                                                   @ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start,
                                                   @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length) {
        Map map=applyManage.findByPage(itemName,start,length);
        return new ResponseEntity<ResponseModel>(successModel("分页查询",map),HttpStatus.OK);
    }

    /**
     * 手机号查询
     * @param phone
     * @return
     */
    public ResponseEntity<ResponseModel> getByPhone(@ApiParam(value = "手机号",required=true ) @PathVariable("phone") String phone) {
        List<org.garen.tourist.mybatis.domain.Apply> applys=applyManage.getByPhone(phone);
        return new ResponseEntity<ResponseModel>(successModel("手机号查询").data(applys),HttpStatus.OK);
    }

    /**
     * 保存
     * @param apply
     * @return
     */
    public ResponseEntity<ResponseModel> saveApply(@ApiParam(value = "报名信息"  )  @Valid @RequestBody Apply apply) {
        String msg=applyValid.saveApplyValid(apply);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        int i=applyManage.saveApply(apply);
        return new ResponseEntity<ResponseModel>(successModel("新增成功，数量：" + i),HttpStatus.OK);    }

    /**
     * 修改
     * @param id
     * @param apply
     * @return
     */
    public ResponseEntity<ResponseModel> updateApply(@ApiParam(value = "id",required=true ) @PathVariable("id") Long id,
        @ApiParam(value = "报名信息"  )  @Valid @RequestBody Apply apply) {
        String msg=applyValid.updateApplyValid(apply);
        if(StringUtils.isNotBlank(msg))
            return new ResponseEntity<ResponseModel>(badRequestModel(msg), HttpStatus.OK);
        int i=applyManage.updateApply(id,apply);
        return new ResponseEntity<ResponseModel>(successModel("修改成功，数量：" + i),HttpStatus.OK);
    }

}
