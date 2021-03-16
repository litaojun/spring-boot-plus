package dg.bestv.dgpoc.controller;

import dg.bestv.dgpoc.entity.DgOperateLog;
import dg.bestv.dgpoc.service.DgOperateLogService;
import lombok.extern.slf4j.Slf4j;
import dg.bestv.dgpoc.param.DgOperateLogPageParam;
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
 * 日志表 控制器
 *
 * @author li.taojun
 * @since 2021-03-12
 */
@Slf4j
@RestController
@RequestMapping("/dgOperateLog")
@Module("dgpoc")
@Api(value = "日志表API", tags = {"日志表"})
public class DgOperateLogController extends BaseController {

    @Autowired
    private DgOperateLogService dgOperateLogService;

    /**
     * 添加日志表
     */
    @PostMapping("/add")
    @OperationLog(name = "添加日志表", type = OperationLogType.ADD)
    @ApiOperation(value = "添加日志表", response = ApiResult.class)
    public ApiResult<Boolean> addDgOperateLog(@Validated(Add.class) @RequestBody DgOperateLog dgOperateLog) throws Exception {
        boolean flag = dgOperateLogService.saveDgOperateLog(dgOperateLog);
        return ApiResult.result(flag);
    }

    /**
     * 修改日志表
     */
    @PostMapping("/update")
    @OperationLog(name = "修改日志表", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改日志表", response = ApiResult.class)
    public ApiResult<Boolean> updateDgOperateLog(@Validated(Update.class) @RequestBody DgOperateLog dgOperateLog) throws Exception {
        boolean flag = dgOperateLogService.updateDgOperateLog(dgOperateLog);
        return ApiResult.result(flag);
    }

    /**
     * 删除日志表
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除日志表", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除日志表", response = ApiResult.class)
    public ApiResult<Boolean> deleteDgOperateLog(@PathVariable("id") Long id) throws Exception {
        boolean flag = dgOperateLogService.deleteDgOperateLog(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取日志表详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "日志表详情", type = OperationLogType.INFO)
    @ApiOperation(value = "日志表详情", response = DgOperateLog.class)
    public ApiResult<DgOperateLog> getDgOperateLog(@PathVariable("id") Long id) throws Exception {
        DgOperateLog dgOperateLog = dgOperateLogService.getById(id);
        return ApiResult.ok(dgOperateLog);
    }

    /**
     * 日志表分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "日志表分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "日志表分页列表", response = DgOperateLog.class)
    public ApiResult<Paging<DgOperateLog>> getDgOperateLogPageList(@Validated @RequestBody DgOperateLogPageParam dgOperateLogPageParam) throws Exception {
        Paging<DgOperateLog> paging = dgOperateLogService.getDgOperateLogPageList(dgOperateLogPageParam);
        return ApiResult.ok(paging);
    }

}

