package dg.bestv.dgpoc.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author:li.taojun
 * @Date: 2021/3/14,21:15
 * @Version:1.0
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    ALREADY_ORDER(1,"已下单"),
    HAVE_OUTBOUND(2,"已出库"),
    HAVE_SIGN(3,"已签收")
    ;
    private Integer value;
    private String message;
}
