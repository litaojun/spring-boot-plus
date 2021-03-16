package dg.bestv.dgpoc.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author:li.taojun
 * @Date: 2021/3/15,15:00
 * @Version:1.0
 */
@Data
public class DgRuleDto  implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 用户ID
     */
    private Long uid;

    /**
     * 商品编号
     */
    private Integer itemid;

    /**
     * 访问数
     */
    private Integer actCnt;

    /**
     * 加购数
     */
    private Integer cartCnt;

    /**
     * 订购数
     */
    private Integer odrCnt;
}
