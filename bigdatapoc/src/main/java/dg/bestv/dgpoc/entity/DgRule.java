package dg.bestv.dgpoc.entity;

import io.geekidea.springbootplus.framework.common.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * 模拟规则
 *
 * @author li.taojun
 * @since 2021-03-14
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DgRule对象")
public class DgRule extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id不能为空", groups = {Update.class})
    @ApiModelProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @NotNull(message = "用户ID不能为空")
    @ApiModelProperty("用户ID")
    @TableField("UID")
    private Long uid;

    @ApiModelProperty("商品编号")
    @TableField("ITEMID")
    private Integer itemid;

    @ApiModelProperty("访问数")
    private Integer actCnt;

    @ApiModelProperty("加购数")
    private Integer cartCnt;

    @ApiModelProperty("订购数")
    private Integer odrCnt;

}
