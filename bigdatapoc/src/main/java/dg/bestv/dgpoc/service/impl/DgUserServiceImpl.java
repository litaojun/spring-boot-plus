package dg.bestv.dgpoc.service.impl;

import dg.bestv.dgpoc.entity.DgUser;
import dg.bestv.dgpoc.mapper.DgUserMapper;
import dg.bestv.dgpoc.service.DgUserService;
import dg.bestv.dgpoc.param.DgUserPageParam;
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

import java.util.List;

/**
 * 用户表 服务实现类
 *
 * @author li.taojun
 * @since 2021-03-12
 */
@Slf4j
@Service
public class DgUserServiceImpl extends BaseServiceImpl<DgUserMapper, DgUser> implements DgUserService {

    @Autowired
    private DgUserMapper dgUserMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveDgUser(DgUser dgUser) throws Exception {
        return super.save(dgUser);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateDgUser(DgUser dgUser) throws Exception {
        return super.updateById(dgUser);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteDgUser(Long id) throws Exception {
        return super.removeById(id);
    }

    @Override
    public Paging<DgUser> getDgUserPageList(DgUserPageParam dgUserPageParam) throws Exception {
        Page<DgUser> page = new PageInfo<>(dgUserPageParam);
        LambdaQueryWrapper<DgUser> wrapper = new LambdaQueryWrapper<>();
        IPage<DgUser> iPage = dgUserMapper.selectPage(page, wrapper);
        return new Paging<DgUser>(iPage);
    }

    @Override
    public List<DgUser> listUsers() {
        return super.list();
    }

}
