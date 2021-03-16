package dg.bestv.dgpoc.controller;

import dg.bestv.dgpoc.entity.DgUser;
import dg.bestv.dgpoc.service.DgUserService;
import lombok.extern.slf4j.Slf4j;
import dg.bestv.dgpoc.param.DgUserPageParam;
import io.geekidea.springbootplus.framework.common.controller.BaseController;
import io.geekidea.springbootplus.framework.common.api.ApiResult;
import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.common.param.IdParam;
import io.geekidea.springbootplus.framework.log.annotation.Module;
import io.geekidea.springbootplus.framework.log.annotation.OperationLog;
import io.geekidea.springbootplus.framework.log.enums.OperationLogType;
import io.geekidea.springbootplus.framework.core.validator.groups.Add;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;
import org.springframework.validation.annotation.Validated;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户表 控制器
 *
 * @author li.taojun
 * @since 2021-03-12
 */
@Slf4j
@RestController
@RequestMapping("/dgUser")
@Module("dgpoc")
@Api(value = "用户表API", tags = {"用户表"})
public class DgUserController extends BaseController {

    @Autowired
    private DgUserService dgUserService;

    /**
     * 添加用户表
     */
    @PostMapping("/add")
    @OperationLog(name = "添加用户表", type = OperationLogType.ADD)
    @ApiOperation(value = "添加用户表", response = ApiResult.class)
    public ApiResult<Boolean> addDgUser(@Validated(Add.class) @RequestBody DgUser dgUser) throws Exception {
        boolean flag = dgUserService.saveDgUser(dgUser);
        return ApiResult.result(flag);
    }

    /**
     * 修改用户表
     */
    @PostMapping("/update")
    @OperationLog(name = "修改用户表", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改用户表", response = ApiResult.class)
    public ApiResult<Boolean> updateDgUser(@Validated(Update.class) @RequestBody DgUser dgUser) throws Exception {
        boolean flag = dgUserService.updateDgUser(dgUser);
        return ApiResult.result(flag);
    }

    /**
     * 删除用户表
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除用户表", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除用户表", response = ApiResult.class)
    public ApiResult<Boolean> deleteDgUser(@PathVariable("id") Long id) throws Exception {
        boolean flag = dgUserService.deleteDgUser(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取用户表详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "用户表详情", type = OperationLogType.INFO)
    @ApiOperation(value = "用户表详情", response = DgUser.class)
    public ApiResult<DgUser> getDgUser(@PathVariable("id") Long id) throws Exception {
        DgUser dgUser = dgUserService.getById(id);
        return ApiResult.ok(dgUser);
    }

    /**
     * 用户表分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "用户表分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "用户表分页列表", response = DgUser.class)
    public ApiResult<Paging<DgUser>> getDgUserPageList(@Validated @RequestBody DgUserPageParam dgUserPageParam) throws Exception {
        Paging<DgUser> paging = dgUserService.getDgUserPageList(dgUserPageParam);
        return ApiResult.ok(paging);
    }

}

