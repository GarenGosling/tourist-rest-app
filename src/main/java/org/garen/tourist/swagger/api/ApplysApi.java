/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.garen.tourist.swagger.api;


import io.swagger.annotations.*;
import org.garen.tourist.swagger.model.Apply;
import org.garen.tourist.swagger.model.ErrorModel;
import org.garen.tourist.swagger.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-30T13:16:24.540Z")

@Api(value = "applys", description = "the applys API")
public interface ApplysApi {

    @ApiOperation(value = "id删除", notes = "根据id删除报名信息 ", response = ResponseModel.class, tags={"apply",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/applys/{id}",
        method = RequestMethod.DELETE)
    ResponseEntity<ResponseModel> deleteApply(@ApiParam(value = "id", required = true) @PathVariable("id") Long id);


    @ApiOperation(value = "查询全部报名信息", notes = "查询全部报名信息 ", response = ResponseModel.class, tags={"apply",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/applys",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> findAll();


    @ApiOperation(value = "id查询", notes = "根据id查询报名信息 ", response = ResponseModel.class, tags={"apply",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/applys/{id}",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getApply(@ApiParam(value = "id", required = true) @PathVariable("id") Long id);



    @ApiOperation(value = "项目名分页查询", notes = "根据项目名分页查询报名信息 ", response = ResponseModel.class, tags={ "apply", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
            @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })

    @RequestMapping(value = "/applys/page",
            method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByPage(@ApiParam(value = "项目名") @RequestParam(value = "itemName", required = false) String itemName, @ApiParam(value = "分页开始索引") @RequestParam(value = "start", required = false) Integer start, @ApiParam(value = "每页数量") @RequestParam(value = "length", required = false) Integer length);



    @ApiOperation(value = "手机号查询", notes = "根据手机号查询查询报名信息 ", response = ResponseModel.class, tags={"apply",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/applys/phone/{phone}",
        method = RequestMethod.GET)
    ResponseEntity<ResponseModel> getByPhone(@ApiParam(value = "手机号", required = true) @PathVariable("phone") String phone);


    @ApiOperation(value = "新增报名信息", notes = "新增报名信息 ", response = ResponseModel.class, tags={"apply",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/applys",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<ResponseModel> saveApply(@ApiParam(value = "报名信息") @Valid @RequestBody Apply apply);


    @ApiOperation(value = "修改报名信息", notes = "根据id修改报名信息 ", response = ResponseModel.class, tags={"apply",  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful response", response = ResponseModel.class),
        @ApiResponse(code = 200, message = "unexpected error", response = ErrorModel.class) })
    
    @RequestMapping(value = "/applys/{id}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<ResponseModel> updateApply(@ApiParam(value = "id", required = true) @PathVariable("id") Long id, @ApiParam(value = "报名信息") @Valid @RequestBody Apply apply);

}
