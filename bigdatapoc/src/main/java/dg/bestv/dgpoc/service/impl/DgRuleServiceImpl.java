package dg.bestv.dgpoc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import dg.bestv.dgpoc.converter.DgPocInConverter;
import dg.bestv.dgpoc.converter.DgPocOutConverter;
import dg.bestv.dgpoc.dto.DgOpItemDto;
import dg.bestv.dgpoc.dto.DgRuleDto;
import dg.bestv.dgpoc.entity.DgGoods;
import dg.bestv.dgpoc.entity.DgRule;
import dg.bestv.dgpoc.mapper.DgRuleMapper;
import dg.bestv.dgpoc.service.DgRuleService;
import dg.bestv.dgpoc.param.DgRulePageParam;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.geekidea.springbootplus.framework.common.service.impl.BaseServiceImpl;
import io.geekidea.springbootplus.framework.core.pagination.Paging;
import io.geekidea.springbootplus.framework.core.pagination.PageInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.transaction.annotation.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 模拟规则 服务实现类
 *
 * @author li.taojun
 * @since 2021-03-14
 */
@Slf4j
@Service
public class DgRuleServiceImpl extends BaseServiceImpl<DgRuleMapper, DgRule> implements DgRuleService {

    @Autowired
    private DgRuleMapper dgRuleMapper;

    @Autowired
    DgPocInConverter dgPocInConverter;
    @Autowired
    DgPocOutConverter dgPocOutConverter;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveDgRule(DgRule dgRule) throws Exception {
        return super.save(dgRule);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateDgRule(DgRule dgRule) throws Exception {
        return super.updateById(dgRule);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteDgRule(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<DgRule> getDgRulePageList(DgRulePageParam dgRulePageParam) throws Exception {
        Page<DgRule> page = new PageInfo<>(dgRulePageParam);
        LambdaQueryWrapper<DgRule> wrapper = new LambdaQueryWrapper<>();
        IPage<DgRule> iPage = dgRuleMapper.selectPage(page, wrapper);
        return new Paging<DgRule>(iPage);
    }

    @Override
    public void updateCntByOperatorType(DgOpItemDto dto) {
        dgRuleMapper.updateNumByOperateType(dto);
    }

    @Override
    public DgRule queryMaxByActAddCart() {
        return dgRuleMapper.queryMaxByActAddCart();
    }

    @Override
    public DgRule queryByUidOrItemid(Long uid, Integer itemid) {
        QueryWrapper<DgRule> wrapper = new QueryWrapper<>();
        wrapper.eq("UID",uid);
        wrapper.eq("ITEMID",itemid);
        List<DgRule> dgGoodsList = dgRuleMapper.selectList(wrapper);
        if(!CollectionUtils.isEmpty(dgGoodsList)){
            return dgGoodsList.get(0);
        }
        return null;
    }

    @Override
    public List<DgRuleDto> listRule() {
        return dgPocOutConverter.vo2dtoListRule(super.list());
    }


}
