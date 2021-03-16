package dg.bestv.dgpoc.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import io.geekidea.springbootplus.framework.core.pagination.BasePageOrderParam;

/**
 * <pre>
 * 模拟规则 分页参数对象
 * </pre>
 *
 * @author li.taojun
 * @date 2021-03-14
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "模拟规则分页参数")
public class DgRulePageParam extends BasePageOrderParam {
    private static final long serialVersionUID = 1L;
}
