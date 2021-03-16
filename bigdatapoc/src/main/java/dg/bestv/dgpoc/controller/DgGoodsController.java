package dg.bestv.dgpoc.controller;

import dg.bestv.dgpoc.entity.DgGoods;
import dg.bestv.dgpoc.service.DgGoodsService;
import lombok.extern.slf4j.Slf4j;
import dg.bestv.dgpoc.param.DgGoodsPageParam;
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
 * 商品表 控制器
 *
 * @author li.taojun
 * @since 2021-03-12
 */
@Slf4j
@RestController
@RequestMapping("/dgGoods")
@Module("dgpoc")
@Api(value = "商品表API", tags = {"商品表"})
public class DgGoodsController extends BaseController {

    @Autowired
    private DgGoodsService dgGoodsService;

    /**
     * 添加商品表
     */
    @PostMapping("/add")
    @OperationLog(name = "添加商品表", type = OperationLogType.ADD)
    @ApiOperation(value = "添加商品表", response = ApiResult.class)
    public ApiResult<Boolean> addDgGoods(@Validated(Add.class) @RequestBody DgGoods dgGoods) throws Exception {
        boolean flag = dgGoodsService.saveDgGoods(dgGoods);
        return ApiResult.result(flag);
    }

    /**
     * 修改商品表
     */
    @PostMapping("/update")
    @OperationLog(name = "修改商品表", type = OperationLogType.UPDATE)
    @ApiOperation(value = "修改商品表", response = ApiResult.class)
    public ApiResult<Boolean> updateDgGoods(@Validated(Update.class) @RequestBody DgGoods dgGoods) throws Exception {
        boolean flag = dgGoodsService.updateDgGoods(dgGoods);
        return ApiResult.result(flag);
    }

    /**
     * 删除商品表
     */
    @PostMapping("/delete/{id}")
    @OperationLog(name = "删除商品表", type = OperationLogType.DELETE)
    @ApiOperation(value = "删除商品表", response = ApiResult.class)
    public ApiResult<Boolean> deleteDgGoods(@PathVariable("id") Long id) throws Exception {
        boolean flag = dgGoodsService.deleteDgGoods(id);
        return ApiResult.result(flag);
    }

    /**
     * 获取商品表详情
     */
    @GetMapping("/info/{id}")
    @OperationLog(name = "商品表详情", type = OperationLogType.INFO)
    @ApiOperation(value = "商品表详情", response = DgGoods.class)
    public ApiResult<DgGoods> getDgGoods(@PathVariable("id") Long id) throws Exception {
        DgGoods dgGoods = dgGoodsService.getById(id);
        return ApiResult.ok(dgGoods);
    }

    /**
     * 商品表分页列表
     */
    @PostMapping("/getPageList")
    @OperationLog(name = "商品表分页列表", type = OperationLogType.PAGE)
    @ApiOperation(value = "商品表分页列表", response = DgGoods.class)
    public ApiResult<Paging<DgGoods>> getDgGoodsPageList(@Validated @RequestBody DgGoodsPageParam dgGoodsPageParam) throws Exception {
        Paging<DgGoods> paging = dgGoodsService.getDgGoodsPageList(dgGoodsPageParam);
        return ApiResult.ok(paging);
    }

}

