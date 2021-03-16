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
 * 商品表
 *
 * @author li.taojun
 * @since 2021-03-12
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DgGoods对象")
public class DgGoods extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "id不能为空", groups = {Update.class})
    @ApiModelProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品编号")
    @TableField("ITEMID")
    private Integer itemid;

    @ApiModelProperty("商品一级分类")
    @TableField("GROUP1")
    private String group1;

    @ApiModelProperty("商品二级分类")
    @TableField("GROUP2")
    private String group2;

    @ApiModelProperty("商品名称")
    @TableField("ITEMNAME")
    private String itemname;

    @ApiModelProperty("销售价格")
    @TableField("SALEPRICE")
    private Integer saleprice;

}
