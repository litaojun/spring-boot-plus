package dg.bestv.dgpoc.service.impl;

import dg.bestv.dgpoc.entity.DgOperateLog;
import dg.bestv.dgpoc.mapper.DgOperateLogMapper;
import dg.bestv.dgpoc.service.DgOperateLogService;
import dg.bestv.dgpoc.param.DgOperateLogPageParam;
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

/**
 * 日志表 服务实现类
 *
 * @author li.taojun
 * @since 2021-03-12
 */
@Slf4j
@Service
public class DgOperateLogServiceImpl extends BaseServiceImpl<DgOperateLogMapper, DgOperateLog> implements DgOperateLogService {

    @Autowired
    private DgOperateLogMapper dgOperateLogMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveDgOperateLog(DgOperateLog dgOperateLog) throws Exception {
        return super.save(dgOperateLog);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateDgOperateLog(DgOperateLog dgOperateLog) throws Exception {
        return super.updateById(dgOperateLog);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteDgOperateLog(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<DgOperateLog> getDgOperateLogPageList(DgOperateLogPageParam dgOperateLogPageParam) throws Exception {
        Page<DgOperateLog> page = new PageInfo<>(dgOperateLogPageParam);
        LambdaQueryWrapper<DgOperateLog> wrapper = new LambdaQueryWrapper<>();
        IPage<DgOperateLog> iPage = dgOperateLogMapper.selectPage(page, wrapper);
        return new Paging<DgOperateLog>(iPage);
    }

}
