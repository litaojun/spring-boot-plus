package dg.bestv.dgpoc.service;

import dg.bestv.dgpoc.dto.DgOrderDto;
import dg.bestv.dgpoc.entity.DgOrder;
import dg.bestv.dgpoc.param.DgOrderPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

import java.util.Date;

/**
 * 订单表 服务类
 *
 * @author li.taojun
 * @since 2021-03-12
 */
public interface DgOrderService extends BaseService<DgOrder> {

    /**
     * 保存
     *
     * @param dgOrder
     * @return
     * @throws Exception
     */
    boolean saveDgOrder(DgOrder dgOrder) throws Exception;

    /**
     * 修改
     *
     * @param dgOrder
     * @return
     * @throws Exception
     */
    boolean updateDgOrder(DgOrder dgOrder) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDgOrder(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param dgOrderQueryParam
     * @return
     * @throws Exception
     */
    Paging<DgOrder> getDgOrderPageList(DgOrderPageParam dgOrderPageParam) throws Exception;

//
//    Boolean userOrderGoods();
//
//    Boolean user


    Date selectMinUtime();
    /**
     * 通过订单最新时间查询
     * @param utime
     * @return
     */
    DgOrderDto queryOrderByOTime(Date utime);

}
