package dg.bestv.dgpoc.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author:li.taojun
 * @Date: 2021/3/14,21:16
 * @Version:1.0
 */
@Getter
@AllArgsConstructor
public enum UserOperateType {
    VISIT(0,"访问"),
    ADD_TO_CART(1,"加购"),
    USER_ORDER(2,"用户下单"),
    OUT_WAREHOUSE(3,"出库"),
    USER_SIGN(4,"签收")
    ;
    private Integer value;
    private String message;
}
