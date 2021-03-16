package dg.bestv.dgpoc.consts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Random;

/**
 * @Author:li.taojun
 * @Date: 2021/3/14,21:13
 * @Version:1.0
 */
@Getter
@AllArgsConstructor
public enum UserFlagEnum {
    ACTIVE_USER(0,"活跃用户"),
    SLEEP_CUSTOMER(1,"睡眠客户")
    ;
    private Integer value;
    private String message;

    public static Integer randomSelectSourceValue(){
        Random random = new Random();
        //TODO 50需可配置
        int num = random.nextInt(values().length * 20);
        return num!=0 ? ACTIVE_USER.value:SLEEP_CUSTOMER.value;
    }

}
