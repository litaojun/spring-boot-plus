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
 * 用户表
 *
 * @author li.taojun
 * @since 2021-03-12
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "DgUser对象")
public class DgUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "uid不能为空", groups = {Update.class})
    @ApiModelProperty("ID")
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户名--U+UID")
    @TableField("UNAME")
    private String uname;

    @ApiModelProperty("用户生日-随机")
    @TableField("UBTH")
    private String ubth;

    @ApiModelProperty("城市-随机-上海/北京/深圳")
    @TableField("CITY")
    private String city;

    @ApiModelProperty("用户来源-随机-电话/APP/第三方")
    @TableField("SOURCE")
    private String source;

    @ApiModelProperty("预存款 取整（随机数（1-10000）/100）")
    @TableField("ADVANCE")
    private Integer advance;

    @ApiModelProperty("积分 取整（随机数（1-10000）/100）")
    @TableField("POINT")
    private Integer point;

    @ApiModelProperty("隐藏标志-随机（0，1）-0:活跃客户；1：睡眠客户")
    @TableField("FLAG")
    private Boolean flag;

}
