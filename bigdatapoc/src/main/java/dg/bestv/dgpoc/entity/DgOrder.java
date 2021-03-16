package dg.bestv.dgpoc.entity;

import io.geekidea.springbootplus.framework.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import io.geekidea.springbootplus.framework.core.validator.groups.Update;

/**
 * 订单表
 *
 * @author li.taojun
 * @since 2021-03-12
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DgOrder对象")
public class DgOrder extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id不能为空", groups = {Update.class})
    @ApiModelProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("订单ID")
    @TableField("OID")
    private String oid;

    @ApiModelProperty("商品编号")
    @TableField("ITEMID")
    private Integer itemid;

    @ApiModelProperty("商品一级分类")
    @TableField("GROUP1")
    private String group1;

    @ApiModelProperty("商品二级分类")
    @TableField("GROUP2")
    private String group2;

    @ApiModelProperty("订购数量")
    @TableField("OQTY")
    private Integer oqty;

    @NotNull(message = "订购金额不能为空")
    @ApiModelProperty("订购金额")
    @TableField("OAMT")
    private Long oamt;

    @NotNull(message = "订购积分不能为空")
    @ApiModelProperty("订购积分")
    @TableField("POINT")
    private Integer point;

    @ApiModelProperty("订购时间")
    @TableField("OTIME")
    private Date otime;

    @ApiModelProperty("订单状态")
    @TableField("OSTATUS")
    private String ostatus;

    @NotNull(message = "订购用户不能为空")
    @ApiModelProperty("订购用户")
    @TableField("UID")
    private Long uid;

    @ApiModelProperty("对应日志表状态变化时间")
    @TableField("UTIME")
    private Date utime;

}
