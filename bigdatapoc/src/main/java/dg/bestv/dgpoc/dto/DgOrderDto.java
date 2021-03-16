package dg.bestv.dgpoc.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:li.taojun
 * @Date: 2021/3/15,14:37
 * @Version:1.0
 */
@Data
public class DgOrderDto implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 订单ID
     */
    private String oid;

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
     * 订购数量
     */
    private Integer oqty;

    /**
     * 订购金额
     */
    private Long oamt;

    /**
     * 订购积分
     */
    private Integer point;

    /**
     * 订购时间
     */
    private Date otime;

    /**
     * 订单状态
     */
    private String ostatus;

    /**
     * 订购用户
     */
    private Long uid;

    /**
     * 对应日志表状态变化时间
     */
    private Date utime;
}
