package dg.bestv.dgpoc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import dg.bestv.dgpoc.converter.DgPocInConverter;
import dg.bestv.dgpoc.converter.DgPocOutConverter;
import dg.bestv.dgpoc.dto.DgGoodsDto;
import dg.bestv.dgpoc.entity.DgGoods;
import dg.bestv.dgpoc.mapper.DgGoodsMapper;
import dg.bestv.dgpoc.service.DgGoodsService;
import dg.bestv.dgpoc.param.DgGoodsPageParam;
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
 * 商品表 服务实现类
 *
 * @author li.taojun
 * @since 2021-03-12
 */
@Slf4j
@Service
public class DgGoodsServiceImpl extends BaseServiceImpl<DgGoodsMapper, DgGoods> implements DgGoodsService {

    @Autowired
    private DgGoodsMapper dgGoodsMapper;

    @Autowired
    private DgPocInConverter  dgPocInConverter;
    @Autowired
    private DgPocOutConverter dgPocOutConverter;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveDgGoods(DgGoods dgGoods) throws Exception {
        return super.save(dgGoods);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateDgGoods(DgGoods dgGoods) throws Exception {
        return super.updateById(dgGoods);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteDgGoods(Long id) throws Exception {
        return super.removeById(id);
    }



    @Override
    public Paging<DgGoods> getDgGoodsPageList(DgGoodsPageParam dgGoodsPageParam) throws Exception {
        Page<DgGoods> page = new PageInfo<>(dgGoodsPageParam);
        LambdaQueryWrapper<DgGoods> wrapper = new LambdaQueryWrapper<>();
        IPage<DgGoods> iPage = dgGoodsMapper.selectPage(page, wrapper);
        return new Paging<DgGoods>(iPage);
    }

    @Override
    public DgGoods getDgGoodsByItemId(Integer itemid) {
        QueryWrapper<DgGoods> wrapper = new QueryWrapper<>();
        wrapper.eq("ITEMID",itemid);
        List<DgGoods> dgGoodsList = dgGoodsMapper.selectList(wrapper);
        if(!CollectionUtils.isEmpty(dgGoodsList)){
            return dgGoodsList.get(0);
        }
        return null;
    }

    @Override
    public DgGoods getDgGoodsById(Long id) {
        return super.getById(id);
    }

    @Override
    public List<DgGoodsDto> listGoods() {
        return dgPocOutConverter.vo2dtoListGoods(super.list());
    }

}
