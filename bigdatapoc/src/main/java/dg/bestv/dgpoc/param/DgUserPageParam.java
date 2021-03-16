package dg.bestv.dgpoc.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import io.geekidea.springbootplus.framework.core.pagination.BasePageOrderParam;

/**
 * <pre>
 * 用户表 分页参数对象
 * </pre>
 *
 * @author li.taojun
 * @date 2021-03-12
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "用户表分页参数")
public class DgUserPageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 1L;
}
