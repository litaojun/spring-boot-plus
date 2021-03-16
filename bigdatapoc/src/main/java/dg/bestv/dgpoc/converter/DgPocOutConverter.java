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
 * @Date: 2021/3/15,14:27
 * @Version:1.0
 */
@Mapper(componentModel = "spring")
public interface DgPocOutConverter {
    /**
     * 商品表DTO转换
     * @param vo
     * @return
     */
    DgGoodsDto vo2dto(DgGoods vo);

    /**
     * 商品表DTO转换
     * @param vo
     * @return
     */
    List<DgGoodsDto> vo2dtoListGoods(List<DgGoods> vo);

    /**
     * 操作日志表DTO转换
     * @param vo
     * @return
     */
    DgOperateLogDto vo2dto(DgOperateLog vo);


    /**
     * 订单表DTO转换
     * @param vo
     * @return
     */
    DgOrderDto vo2dto(DgOrder vo);


    /**
     * 订单表DTO转换
     * @param vo
     * @return
     */
    List<DgOrderDto> vo2dtoListOrder(List<DgOrder> vo);

    /**
     * 模拟规则表DTO转换
     * @param vo
     * @return
     */
    DgRuleDto vo2dto(DgRule vo);

    /**
     * 模拟规则表DTO转换
     * @param vo
     * @return
     */
    List<DgRuleDto> vo2dtoListRule(List<DgRule> vo);
}
