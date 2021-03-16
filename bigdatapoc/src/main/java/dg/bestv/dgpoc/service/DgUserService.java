package dg.bestv.dgpoc.service;

import dg.bestv.dgpoc.entity.DgUser;
import dg.bestv.dgpoc.param.DgUserPageParam;
import io.geekidea.springbootplus.framework.common.service.BaseService;
import io.geekidea.springbootplus.framework.core.pagination.Paging;

import java.util.List;

/**
 * 用户表 服务类
 *
 * @author li.taojun
 * @since 2021-03-12
 */
public interface DgUserService extends BaseService<DgUser> {

    /**
     * 保存
     *
     * @param dgUser
     * @return
     * @throws Exception
     */
    boolean saveDgUser(DgUser dgUser) throws Exception;

    /**
     * 修改
     *
     * @param dgUser
     * @return
     * @throws Exception
     */
    boolean updateDgUser(DgUser dgUser) throws Exception;

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteDgUser(Long id) throws Exception;


    /**
     * 获取分页对象
     *
     * @param dgUserQueryParam
     * @return
     * @throws Exception
     */
    Paging<DgUser> getDgUserPageList(DgUserPageParam dgUserPageParam) throws Exception;


    /**
     * 查询出所有用户
     * @return
     */
    List<DgUser> listUsers();

}
