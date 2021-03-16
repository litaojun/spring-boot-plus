package dg.bestv.dgpoc.service;

import dg.bestv.dgpoc.dto.DgGoodsDto;
import dg.bestv.dgpoc.entity.DgGoods;
import dg.bestv.dgpoc.param.DgGoodsPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

import java.util.List;

/**
 * 商品表 服务类
 *
 * @author li.taojun
 * @since 2021-03-12
 */
public interface DgGoodsService extends BaseService<DgGoods> {

    /**
     * 保存
     *
     * @param dgGoods
     * @return
     * @throws Exception
     */
    boolean saveDgGoods(DgGoods dgGoods) throws Exception;

    /**
     * 修改
     *
     * @param dgGoods
     * @return
     * @throws Exception
     */
    boolean updateDgGoods(DgGoods dgGoods) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDgGoods(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param dgGoodsQueryParam
     * @return
     * @throws Exception
     */
    Paging<DgGoods> getDgGoodsPageList(DgGoodsPageParam dgGoodsPageParam) throws Exception;


    /**
     * 根据商品ID查询商品信息
     * @param itemid
     * @return
     */
    DgGoods getDgGoodsByItemId(Integer itemid);


    DgGoods getDgGoodsById(Long id);


    /**
     * 查询出所有商品
     * @return
     */
    List<DgGoodsDto> listGoods();

}
