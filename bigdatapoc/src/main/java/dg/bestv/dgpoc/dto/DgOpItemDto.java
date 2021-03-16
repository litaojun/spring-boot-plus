package dg.bestv.dgpoc.dto;

import dg.bestv.dgpoc.entity.DgUser;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:li.taojun
 * @Date: 2021/3/14,18:43
 * @Version:1.0
 */
@Data
public class DgOpItemDto implements Serializable {
    /**
     *用户ID
     */
    private Long uid;

    /**
     * 是否睡眠客户
     */
    private Boolean userFlag;

    /**
     *商品编号
     */
    private Integer itemid;

    /**
     * 商品ID
     */
    private Long goodsId;

    /**
     * 操作类型，1 订购，2 加购，3 访问
     */
    private Integer operateType;


    /**
     * 商品一级分类
     */
    private String group1;

    /**
     * 商品二级分类
     */
    private String group2;

    /**
     * 订购数量
     */
    private Integer oqty;

    /**
     * 订购金额
     */
    private Long oamt;

    /**
     * 订单DTO
     */
    private DgOrderDto dgOrderDto;

    /**
     * 用户表
     */
    private DgUser dgUser;

    /**
     * 商品表
     */
    private DgGoodsDto dgGoodsDto;


    public static List<DgUser> dgUserList = null;

    public static List<DgGoodsDto> dgGoodsDtoList = null;

    public static List<DgRuleDto> dgRuleDtoList = null;

    public static Boolean userDataSign = Boolean.FALSE;
}
