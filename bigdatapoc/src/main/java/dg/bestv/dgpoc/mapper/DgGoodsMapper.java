package dg.bestv.dgpoc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import dg.bestv.dgpoc.entity.DgGoods;
import dg.bestv.dgpoc.param.DgGoodsPageParam;

import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import java.io.Serializable;

/**
 * 商品表 Mapper 接口
 *
 * @author li.taojun
 * @since 2021-03-12
 */
@Repository
public interface DgGoodsMapper extends BaseMapper<DgGoods> {


}
