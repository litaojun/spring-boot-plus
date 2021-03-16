package dg.bestv.dgpoc.service;

import dg.bestv.dgpoc.entity.DgOperateLog;
import dg.bestv.dgpoc.param.DgOperateLogPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

/**
 * 日志表 服务类
 *
 * @author li.taojun
 * @since 2021-03-12
 */
public interface DgOperateLogService extends BaseService<DgOperateLog> {

    /**
     * 保存
     *
     * @param dgOperateLog
     * @return
     * @throws Exception
     */
    boolean saveDgOperateLog(DgOperateLog dgOperateLog) throws Exception;

    /**
     * 修改
     *
     * @param dgOperateLog
     * @return
     * @throws Exception
     */
    boolean updateDgOperateLog(DgOperateLog dgOperateLog) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDgOperateLog(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param dgOperateLogQueryParam
     * @return
     * @throws Exception
     */
    Paging<DgOperateLog> getDgOperateLogPageList(DgOperateLogPageParam dgOperateLogPageParam) throws Exception;

}
