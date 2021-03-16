package dg.bestv.dgpoc.controller;

import dg.bestv.dgpoc.entity.DgOrder;
import dg.bestv.dgpoc.service.DgOrderService;
import lombok.extern.slf4j.Slf4j;
import dg.bestv.dgpoc.param.DgOrderPageParam;
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
 * 订单表 控制器
 *
 * @author li.taojun
 * @since 2021-03-12
 */
@Slf4j
@RestController
@RequestMapping("/dgOrder")
@Module("dgpoc")
@Api(value = "订单表API", tags = {"订单表"})
public class DgOrderController extends BaseController {

    @Autowired
    private DgOrderService dgOrderService;

    /**
     * 添加订单表
     */
    @PostMapping("/add")
    @OperationLog(name = "添加订单表", type = OperationLogType.ADD)
    @ApiOperation(value = "添加订单表", response = ApiResult.class)
    public ApiResult<Boolean> addDgOrder(@Validated(Add.class) @RequestBody DgOrder dgOrder) throws Exception {
        boolean flag = dgOrderService.saveDgOrder(dgOrder);
        return ApiResult.result(flag);
    }

    /**
     * 修改订单表
     */
    @PostMapping("/update")
    @OperationLog(name = "修改订单表", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改订单表", response = ApiResult.class)
    public ApiResult<Boolean> updateDgOrder(@Validated(Update.class) @RequestBody DgOrder dgOrder) throws Exception {
        boolean flag = dgOrderService.updateDgOrder(dgOrder);
        return ApiResult.result(flag);
    }

    /**
     * 删除订单表
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除订单表", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除订单表", response = ApiResult.class)
    public ApiResult<Boolean> deleteDgOrder(@PathVariable("id") Long id) throws Exception {
        boolean flag = dgOrderService.deleteDgOrder(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取订单表详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "订单表详情", type = OperationLogType.INFO)
    @ApiOperation(value = "订单表详情", response = DgOrder.class)
    public ApiResult<DgOrder> getDgOrder(@PathVariable("id") Long id) throws Exception {
        DgOrder dgOrder = dgOrderService.getById(id);
        return ApiResult.ok(dgOrder);
    }

    /**
     * 订单表分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "订单表分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "订单表分页列表", response = DgOrder.class)
    public ApiResult<Paging<DgOrder>> getDgOrderPageList(@Validated @RequestBody DgOrderPageParam dgOrderPageParam) throws Exception {
        Paging<DgOrder> paging = dgOrderService.getDgOrderPageList(dgOrderPageParam);
        return ApiResult.ok(paging);
    }

}

