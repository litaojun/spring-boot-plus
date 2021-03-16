package dg.bestv.dgpoc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import dg.bestv.dgpoc.converter.DgPocInConverter;
import dg.bestv.dgpoc.converter.DgPocOutConverter;
import dg.bestv.dgpoc.dto.DgOrderDto;
import dg.bestv.dgpoc.entity.DgOrder;
import dg.bestv.dgpoc.mapper.DgOrderMapper;
import dg.bestv.dgpoc.service.DgOrderService;
import dg.bestv.dgpoc.param.DgOrderPageParam;
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

import java.util.Date;
import java.util.List;

/**
 * 订单表 服务实现类
 *
 * @author li.taojun
 * @since 2021-03-12
 */
@Slf4j
@Service
public class DgOrderServiceImpl extends BaseServiceImpl<DgOrderMapper, DgOrder> implements DgOrderService {

    @Autowired
    private DgOrderMapper dgOrderMapper;
    @Autowired
    private DgPocOutConverter dgPocOutConverter;
    @Autowired
    private DgPocInConverter dgPocInConverter;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveDgOrder(DgOrder dgOrder)  {
        return super.save(dgOrder);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateDgOrder(DgOrder dgOrder) throws Exception {
        return super.updateById(dgOrder);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteDgOrder(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<DgOrder> getDgOrderPageList(DgOrderPageParam dgOrderPageParam) throws Exception {
        Page<DgOrder> page = new PageInfo<>(dgOrderPageParam);
        LambdaQueryWrapper<DgOrder> wrapper = new LambdaQueryWrapper<>();
        IPage<DgOrder> iPage = dgOrderMapper.selectPage(page, wrapper);
        return new Paging<DgOrder>(iPage);
    }

    @Override
    public Date selectMinUtime() {
        return dgOrderMapper.selectMinUtime();
    }

    @Override
    public DgOrderDto queryOrderByOTime(Date utime) {
        QueryWrapper<DgOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("OTIME",utime);
        queryWrapper.ne("OSTATUS","已签收");
        List<DgOrder> dgOrderList = dgOrderMapper.selectList(queryWrapper);
        if(CollectionUtils.isEmpty(dgOrderList)){
            return null;
        }
        return dgPocOutConverter.vo2dto(dgOrderList.get(0));
    }

}
