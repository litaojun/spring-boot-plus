package dg.bestv.dgpoc.service;

import dg.bestv.dgpoc.dto.DgGoodsDto;
import dg.bestv.dgpoc.dto.DgOpItemDto;
import dg.bestv.dgpoc.dto.DgOrderDto;
import dg.bestv.dgpoc.entity.DgUser;

import java.util.List;

/**
 * @Author:li.taojun
 * @Date: 2021/3/14,18:37
 * @Version:1.0
 */
public interface UserOperateService {
    /**
     * 用户订购一个商品
     * @return
     */
    public Boolean userOrderItem(DgOpItemDto dgOpItemDto) throws Exception;

    /**
     * 用户加购商品
     * @return
     */
    public Boolean userCartItem(DgOpItemDto dgOpItemDto) throws Exception;

    /**
     * 用户访问一个商品
     * @return
     */
    public Boolean userActItem(DgOpItemDto dgOpItemDto) throws Exception;

    /**
     * 出库
     * @param dgOpItemDto
     * @return
     */
    public Boolean userOutWarehourse(DgOpItemDto dgOpItemDto) throws Exception;

    /**
     * 签收
     * @param dgOpItemDto
     * @return
     */
    public Boolean userSign(DgOpItemDto dgOpItemDto) throws Exception;


    /**
     * 随机选择一个用户
     * @return
     */
    public DgUser randSelectUser();

    /**
     * 随机选择一个商品
     * @return
     */
    public DgGoodsDto randSelectItem();

    /**
     * 选择加购+访问最大的商品
     * @return
     */
    public DgOpItemDto maxActAddCartItemUser();

    /**
     * 选择加购+访问最大的用户
     * @return
     */
    public DgOpItemDto randomSelect();

    /**
     * 选择一条min(UTIME)非签收订单
     * @return
     */
    public DgOpItemDto minUtimeNonSignOrder() throws Exception;

    /**
     * 通过最早订单时间获取DgOpItemDto
     * @return
     */
    public Boolean runByOrder() throws Exception;


    /**
     * 随机选择操作类型并执行
     * @param
     * @param runType  0,随机选择用户商品执行；1 选择最大次数（访问+加购）的用户商品执行
     * @return
     */
    public Boolean randOperateBySelectType(int runType) throws Exception;


    /**
     * 判断是否隐藏用户
     * @return
     */
    public void judgeInvisibleUser(DgOpItemDto dgOpItemDto);


    public Boolean addUserData() throws Exception;




}
