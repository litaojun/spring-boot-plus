package dg.bestv.dgpoc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dg.bestv.dgpoc.entity.DgUser;
import dg.bestv.dgpoc.param.DgUserPageParam;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

/**
 * 用户表 Mapper 接口
 *
 * @author li.taojun
 * @since 2021-03-12
 */
@Repository
public interface DgUserMapper extends BaseMapper<DgUser> {


}
