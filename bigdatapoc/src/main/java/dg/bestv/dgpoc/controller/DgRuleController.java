package dg.bestv.dgpoc.controller;

import dg.bestv.dgpoc.entity.DgRule;
import dg.bestv.dgpoc.service.DgRuleService;
import lombok.extern.slf4j.Slf4j;
import dg.bestv.dgpoc.param.DgRulePageParam;
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
 * 模拟规则 控制器
 *
 * @author li.taojun
 * @since 2021-03-14
 */
@Slf4j
@RestController
@RequestMapping("/dgRule")
@Module("dgpoc")
@Api(value = "模拟规则API", tags = {"模拟规则"})
public class DgRuleController extends BaseController {

    @Autowired
    private DgRuleService dgRuleService;

    /**
     * 添加模拟规则
     */
    @PostMapping("/add")
    @OperationLog(name = "添加模拟规则", type = OperationLogType.ADD)
    @ApiOperation(value = "添加模拟规则", response = ApiResult.class)
    public ApiResult<Boolean> addDgRule(@Validated(Add.class) @RequestBody DgRule dgRule) throws Exception {
        boolean flag = dgRuleService.saveDgRule(dgRule);
        return ApiResult.result(flag);
    }

    /**
     * 修改模拟规则
     */
    @PostMapping("/update")
    @OperationLog(name = "修改模拟规则", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改模拟规则", response = ApiResult.class)
    public ApiResult<Boolean> updateDgRule(@Validated(Update.class) @RequestBody DgRule dgRule) throws Exception {
        boolean flag = dgRuleService.updateDgRule(dgRule);
        return ApiResult.result(flag);
    }

    /**
     * 删除模拟规则
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除模拟规则", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除模拟规则", response = ApiResult.class)
    public ApiResult<Boolean> deleteDgRule(@PathVariable("id") Long id) throws Exception {
        boolean flag = dgRuleService.deleteDgRule(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取模拟规则详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "模拟规则详情", type = OperationLogType.INFO)
    @ApiOperation(value = "模拟规则详情", response = DgRule.class)
    public ApiResult<DgRule> getDgRule(@PathVariable("id") Long id) throws Exception {
        DgRule dgRule = dgRuleService.getById(id);
        return ApiResult.ok(dgRule);
    }

    /**
     * 模拟规则分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "模拟规则分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "模拟规则分页列表", response = DgRule.class)
    public ApiResult<Paging<DgRule>> getDgRulePageList(@Validated @RequestBody DgRulePageParam dgRulePageParam) throws Exception {
        Paging<DgRule> paging = dgRuleService.getDgRulePageList(dgRulePageParam);
        return ApiResult.ok(paging);
    }

}

