package dg.bestv.dgpoc.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:li.taojun
 * @Date: 2021/3/15,14:31
 * @Version:1.0
 */
@Data
public class DgGoodsDto implements Serializable {
    /**
     * ID,主键
     */
    private Long id;

    /**
     * 商品编号
     */
    private Integer itemid;

    /**
     * 商品一级分类
     */
    private String group1;

    /**
     * 商品二级分类
     */
    private String group2;

    /**
     * 商品名称
     */
    private String itemname;

    /**
     * 销售价格
     */
    private Integer saleprice;
}
