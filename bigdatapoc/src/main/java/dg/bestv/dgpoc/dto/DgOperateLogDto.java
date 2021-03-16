package dg.bestv.dgpoc.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author:li.taojun
 * @Date: 2021/3/15,14:35
 * @Version:1.0
 */
@Data
public class DgOperateLogDto implements Serializable {
    /**
     * id不能为空
     */
    private Long id;

    /**
     * 订单ID
     */
    private String oid;

    /**
     * 订购用户
     */
    private Long uid;

    /**
     * 订单状态
     */
    private String ostatus;

    /**
     * 对应日志表状态变化时间
     */
    private Date utime;
}
