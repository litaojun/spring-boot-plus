package dg.bestv.dgpoc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dg.bestv.dgpoc.dto.DgOpItemDto;
import dg.bestv.dgpoc.entity.DgRule;
import dg.bestv.dgpoc.param.DgRulePageParam;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

/**
 * 模拟规则 Mapper 接口
 *
 * @author li.taojun
 * @since 2021-03-14
 */
@Repository
public interface DgRuleMapper extends BaseMapper<DgRule> {

    /**
     * 根据用户操作更新订购，加购，访问次数
     * @param dto
     */
    void updateNumByOperateType(DgOpItemDto dto);


    /**
     * 查询最大‘加购+访问’次数的规则
     * @return
     */
    DgRule queryMaxByActAddCart();
}
