package dg.bestv.dgpoc.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

/**
 * @Author:li.taojun
 * @Date: 2021/3/14,21:11
 * @Version:1.0
 */
@Getter
@AllArgsConstructor
public enum UserSourceEnum {
    TEL(1,"电话"),
    APP(2,"APP"),
    THIRD_PARTY(3,"第三方")
    ;
    private Integer value;
    private String message;

    public static Integer randomSelectSourceValue(){
        Random random = new Random();
        return values()[random.nextInt(values().length)].value;
    }

    public static String randomSelectSourceMessage(){
        Random random = new Random();
        return values()[random.nextInt(values().length)].message;
    }
}
