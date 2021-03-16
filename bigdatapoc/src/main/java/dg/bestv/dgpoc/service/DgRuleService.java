package dg.bestv.dgpoc.service;

import dg.bestv.dgpoc.dto.DgOpItemDto;
import dg.bestv.dgpoc.dto.DgRuleDto;
import dg.bestv.dgpoc.entity.DgRule;
import dg.bestv.dgpoc.param.DgRulePageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

import java.util.List;

/**
 * 模拟规则 服务类
 *
 * @author li.taojun
 * @since 2021-03-14
 */
public interface DgRuleService extends BaseService<DgRule> {

    /**
     * 保存
     *
     * @param dgRule
     * @return
     * @throws Exception
     */
    boolean saveDgRule(DgRule dgRule) throws Exception;

    /**
     * 修改
     *
     * @param dgRule
     * @return
     * @throws Exception
     */
    boolean updateDgRule(DgRule dgRule) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDgRule(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param dgRuleQueryParam
     * @return
     * @throws Exception
     */
    Paging<DgRule> getDgRulePageList(DgRulePageParam dgRulePageParam) throws Exception;


    /**
     * 根据操作类型更新訂購，加购，访问次数
     * @param dto
     */
    public void updateCntByOperatorType(DgOpItemDto dto);

    /**
     * 查询最大‘加购+访问’次数的规则
     * @return
     */
    public DgRule queryMaxByActAddCart();


    /**
     * 通过用户ID和商品ID查询一个规则
     * @param uid
     * @param itemid
     * @return
     */
    public DgRule queryByUidOrItemid(Long uid,Integer itemid);


    /**
     * 查询出所有的规则
     * @return
     */
    public List<DgRuleDto> listRule();

}
