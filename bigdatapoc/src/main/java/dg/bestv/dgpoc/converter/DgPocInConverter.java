package dg.bestv.dgpoc.converter;

import dg.bestv.dgpoc.dto.DgGoodsDto;
import dg.bestv.dgpoc.dto.DgOperateLogDto;
import dg.bestv.dgpoc.dto.DgOrderDto;
import dg.bestv.dgpoc.dto.DgRuleDto;
import dg.bestv.dgpoc.entity.DgGoods;
import dg.bestv.dgpoc.entity.DgOperateLog;
import dg.bestv.dgpoc.entity.DgOrder;
import dg.bestv.dgpoc.entity.DgRule;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Author:li.taojun
 * @Date: 2021/3/15,15:08
 * @Version:1.0
 */
@Mapper(componentModel = "spring")
public interface DgPocInConverter {
    /**
     * 商品表DTO转换
     * @param dto
     * @return
     */
    DgGoods vo2dto(DgGoodsDto dto);

    /**
     * 商品表DTO转换
     * @param dto
     * @return
     */
    List<DgGoods> vo2dtoListGoods(List<DgGoodsDto> dto);

    /**
     * 操作日志表DTO转换
     * @param dto
     * @return
     */
    DgOperateLog vo2dto(DgOperateLogDto dto);

    /**
     * 订单表DTO转换
     * @param dto
     * @return
     */
    DgOrder vo2dto(DgOrderDto dto);

    /**
     * 订单表DTO转换
     * @param dto
     * @return
     */
    List<DgOrder> vo2dtoListOrder(List<DgOrderDto> dto);

    /**
     * 模拟规则表DTO转换
     * @param dto
     * @return
     */
    DgRule vo2dto(DgRuleDto dto);
}
