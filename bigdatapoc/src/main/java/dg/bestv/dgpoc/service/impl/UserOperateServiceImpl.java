package dg.bestv.dgpoc.service.impl;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import dg.bestv.dgpoc.component.DgGoodsBuilder;
import dg.bestv.dgpoc.consts.*;
import dg.bestv.dgpoc.converter.DgPocInConverter;
import dg.bestv.dgpoc.converter.DgPocOutConverter;
import dg.bestv.dgpoc.dto.*;
import dg.bestv.dgpoc.entity.DgOrder;
import dg.bestv.dgpoc.entity.DgRule;
import dg.bestv.dgpoc.entity.DgUser;
import dg.bestv.dgpoc.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Author:li.taojun
 * @Date: 2021/3/15,11:54
 * @Version:1.0
 */
@Service
@Slf4j
public class UserOperateServiceImpl implements UserOperateService {
    @Autowired
    DgOrderService dgOrderService;

    @Autowired
    private DgGoodsService dgGoodsService;

    @Autowired
    private DgOperateLogService dgOperateLogService;


    @Autowired
    private DgRuleService dgRuleService;

    @Autowired
    private DgUserService dgUserService;

    @Autowired
    private DgGoodsBuilder goodsBuilder;
    @Autowired
    DgPocInConverter dgPocInConverter;
    @Autowired
    DgPocOutConverter dgPocOutConverter;

    ObjectMapper mapper = new ObjectMapper();

    @Value("${poc.item.userFlag:0}")
    private Integer outFlag;

    @Override
    @Transactional
    public Boolean userOrderItem(DgOpItemDto dgOpItemDto) throws Exception {
        log.info("userOrderItem = {}",mapper.writeValueAsString(dgOpItemDto));
        //判断睡眠客户
        if(dgOpItemDto.getUserFlag()){
            return Boolean.FALSE;
        }
        //写订单表
        DgOrder dgOrder = dgPocInConverter.vo2dto(goodsBuilder.genDgOrderDto(dgOpItemDto));
        log.info("dgOrder = {}",mapper.writeValueAsString(dgOrder));
        dgOrderService.saveDgOrder(dgOrder);
        dgOrder.setOid(String.format("%s%s",new String[]{"U",String.valueOf(dgOrder.getId())}));
        dgOrderService.updateDgOrder(dgOrder);

        //写操作日志表
        DgOperateLogDto dgOperateLogDto = goodsBuilder.genDgOperateLog(dgPocOutConverter.vo2dto(dgOrder));
        dgOperateLogService.saveDgOperateLog(dgPocInConverter.vo2dto(dgOperateLogDto));

        //通过用户ID和商品ID查询模拟规则表
        DgRule dgRule = dgRuleService.queryByUidOrItemid(dgOpItemDto.getUid(),dgOpItemDto.getItemid());
        if(dgRule == null){
            //未找到规则数据
            return dgRuleService.saveDgRule(dgPocInConverter.vo2dto(goodsBuilder.genDgRuleDto(dgOpItemDto)));
        }
        dgRule.setOdrCnt(dgRule.getOdrCnt()+1);
        return dgRuleService.updateDgRule(dgRule);
    }

    @Override
    public Boolean userCartItem(DgOpItemDto dgOpItemDto) throws Exception {
        log.info("userCartItem = {}",JSONUtil.toJsonStr(dgOpItemDto));
        //通过用户ID和商品ID查询模拟规则表
        DgRule dgRule = dgRuleService.queryByUidOrItemid(dgOpItemDto.getUid(),dgOpItemDto.getItemid());
        if(dgRule == null){
            //未找到规则数据
            return dgRuleService.saveDgRule(dgPocInConverter.vo2dto(goodsBuilder.genDgRuleDto(dgOpItemDto)));
        }
        dgRule.setCartCnt(dgRule.getCartCnt()+1);
        return dgRuleService.updateDgRule(dgRule);
    }

    @Override
    public Boolean userActItem(DgOpItemDto dgOpItemDto) throws Exception {
        log.info("userActItem = ",JSONUtil.toJsonStr(dgOpItemDto));
        //通过用户ID和商品ID查询模拟规则表
        DgRule dgRule = dgRuleService.queryByUidOrItemid(dgOpItemDto.getUid(),dgOpItemDto.getItemid());
        if(dgRule == null){
            //未找到规则数据
            return dgRuleService.saveDgRule(dgPocInConverter.vo2dto(goodsBuilder.genDgRuleDto(dgOpItemDto)));
        }
        dgRule.setActCnt(dgRule.getActCnt()+1);
        return dgRuleService.updateDgRule(dgRule);
    }

    @Override
    public Boolean userOutWarehourse(DgOpItemDto dgOpItemDto) throws Exception {
        log.info("userOutWarehourse = {}",JSONUtil.toJsonStr(dgOpItemDto));
        //更新订单DTO数据，状态出库，最后操作时间为当前时间
        goodsBuilder.genDgOrder(dgOpItemDto);
        dgOrderService.updateDgOrder(dgPocInConverter.vo2dto(dgOpItemDto.getDgOrderDto()));
        //写操作日志
        DgOperateLogDto dgOperateLogDto = goodsBuilder.genDgOperateLog(dgOpItemDto.getDgOrderDto());
        return dgOperateLogService.saveDgOperateLog(dgPocInConverter.vo2dto(dgOperateLogDto));
    }

    @Override
    public Boolean userSign(DgOpItemDto dgOpItemDto) throws Exception {
        log.info("userSign = {}",JSONUtil.toJsonStr(dgOpItemDto));
        //更新订单DTO数据，状态出库，最后操作时间为当前时间，积分
        goodsBuilder.genDgOrder(dgOpItemDto);
        dgOrderService.updateDgOrder(dgPocInConverter.vo2dto(dgOpItemDto.getDgOrderDto()));
        //写操作日志
        DgOperateLogDto dgOperateLogDto = goodsBuilder.genDgOperateLog(dgOpItemDto.getDgOrderDto());
        dgOperateLogService.saveDgOperateLog(dgPocInConverter.vo2dto(dgOperateLogDto));
        //更新用户积分数据
        int point = dgOpItemDto.getDgUser().getPoint() + dgOpItemDto.getDgOrderDto().getPoint();
        dgOpItemDto.getDgUser().setPoint(point);
        return dgUserService.updateDgUser(dgOpItemDto.getDgUser());
    }

    @Override
    public DgUser randSelectUser() {
        if(DgOpItemDto.dgUserList == null){
            DgOpItemDto.dgUserList = dgUserService.listUsers();
        }
        Random random = new Random();
        //TODO,2999可配置
        return DgOpItemDto.dgUserList.get(random.nextInt(3000));
    }

    @Override
    public DgGoodsDto randSelectItem() {
        if(DgOpItemDto.dgGoodsDtoList == null){
            DgOpItemDto.dgGoodsDtoList = dgGoodsService.listGoods();
        }
        Random random = new Random();
        return DgOpItemDto.dgGoodsDtoList.get(random.nextInt(16));
    }

    @Override
    public DgOpItemDto maxActAddCartItemUser() {
        Random random = new Random();
        DgOpItemDto dgOpItemDto = new DgOpItemDto();
        List<DgRuleDto> dgRuleDtoList = dgRuleService.listRule();
        DgRuleDto dgRuleDto = dgRuleDtoList.stream().sorted((o1, o2) ->
                                     o1.getActCnt() + o1.getCartCnt() - o2.getActCnt() - o2.getCartCnt()
                                ).findFirst().get();
        dgOpItemDto.setUid(dgRuleDto.getUid());
        dgOpItemDto.setItemid(dgRuleDto.getItemid());

        dgOpItemDto.setDgUser(dgUserService.getById(dgRuleDto.getUid()));
        dgOpItemDto.setDgGoodsDto(
                            dgPocOutConverter.vo2dto(
                                   dgGoodsService.getDgGoodsByItemId(dgRuleDto.getItemid()
                            )
                ));
        DgGoodsDto dgGoodsDto = dgOpItemDto.getDgGoodsDto();
        DgUser dgUser = dgOpItemDto.getDgUser();
        dgOpItemDto.setGoodsId(dgGoodsDto.getId());
        dgOpItemDto.setDgUser(dgUser);
        dgOpItemDto.setDgGoodsDto(dgGoodsDto);
        dgOpItemDto.setOqty(random.nextInt(3)+1);
        dgOpItemDto.setOamt((long)dgGoodsDto.getSaleprice()*dgOpItemDto.getOqty());
        dgOpItemDto.setGroup1(dgGoodsDto.getGroup1());
        dgOpItemDto.setGroup2(dgGoodsDto.getGroup2());
        this.judgeInvisibleUser(dgOpItemDto);
        return dgOpItemDto;
    }

    @Override
    public DgOpItemDto randomSelect() {
        Random random = new Random();
        DgOpItemDto dgOpItemDto = new DgOpItemDto();
        DgUser dgUser = this.randSelectUser();
        DgGoodsDto dgGoodsDto =  this.randSelectItem();
        dgOpItemDto.setUid(dgUser.getId());
        dgOpItemDto.setItemid(dgGoodsDto.getItemid());
        dgOpItemDto.setGoodsId(dgGoodsDto.getId());
        dgOpItemDto.setDgUser(dgUser);
        dgOpItemDto.setDgGoodsDto(dgGoodsDto);
        dgOpItemDto.setOqty(random.nextInt(3)+1);
        dgOpItemDto.setOamt((long)dgGoodsDto.getSaleprice()*dgOpItemDto.getOqty());
        dgOpItemDto.setGroup1(dgGoodsDto.getGroup1());
        dgOpItemDto.setGroup2(dgGoodsDto.getGroup2());
        this.judgeInvisibleUser(dgOpItemDto);
        return dgOpItemDto;
    }

    @Override
    public DgOpItemDto minUtimeNonSignOrder() throws Exception {
        DgOpItemDto dgOpItemDto = new DgOpItemDto();
        Date utime = dgOrderService.selectMinUtime();
        DgOrderDto dgOrderDto = dgOrderService.queryOrderByOTime(utime);
        dgOpItemDto.setDgOrderDto(dgOrderDto);
        dgOpItemDto.setUid(dgOrderDto.getUid());
        dgOpItemDto.setItemid(dgOpItemDto.getItemid());
        if(dgOrderDto.getOstatus().equals(OrderStatusEnum.ALREADY_ORDER.getMessage())){
            dgOpItemDto.setOperateType(UserOperateType.OUT_WAREHOUSE.getValue());
        }else if(dgOrderDto.getOstatus().equals(OrderStatusEnum.HAVE_OUTBOUND.getMessage())){
            dgOpItemDto.setOperateType(UserOperateType.USER_SIGN.getValue());
        }else {
            log.info("订单为签收状态，请确认");
            throw new Exception("sss");
        }
        dgOpItemDto.setDgUser(dgUserService.getById(dgOrderDto.getUid()));
        return dgOpItemDto;
    }

    @Override
    public Boolean runByOrder() throws Exception {
        DgOpItemDto dgOpItemDto = this.minUtimeNonSignOrder();
        switch (dgOpItemDto.getOperateType()){
            case 3:
                this.userOutWarehourse(dgOpItemDto);
                break;
            case 4:
                this.userSign(dgOpItemDto);
                break;
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean randOperateBySelectType(int runType) throws Exception {
        Random random = new Random();
        DgOpItemDto dgOpItemDto = runType==0?randomSelect():maxActAddCartItemUser();
        //TODO：10，3均可配置
        Integer operateNum = runType==0?random.nextInt(10):1;
        for(int i=0;i<operateNum;i++){
            dgOpItemDto.setOperateType(random.nextInt(3));
            switch (dgOpItemDto.getOperateType()){
                case 0:
                    this.userActItem(dgOpItemDto);
                    break;
                case 1:
                    this.userCartItem(dgOpItemDto);
                    break;
                case 2:
                    this.userOrderItem(dgOpItemDto);
                    break;
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public void judgeInvisibleUser(DgOpItemDto dgOpItemDto) {
        if(outFlag==1 && dgOpItemDto.getDgUser().getFlag()){
          dgOpItemDto.setUserFlag(Boolean.TRUE);
          return ;
        }
        dgOpItemDto.setUserFlag(Boolean.FALSE);
    }


    public DgUser genDgUser(){
        Random random = new Random();
        DgUser dgUser = new DgUser();
        dgUser.setPoint(random.nextInt(1000));
        dgUser.setAdvance(random.nextInt(1000));
        dgUser.setUbth(goodsBuilder.randomGenUbth());
        dgUser.setCity(CityEnum.randomSelectSourceMessage());
        dgUser.setFlag(UserFlagEnum.randomSelectSourceValue() == 1);
        dgUser.setSource(UserSourceEnum.randomSelectSourceMessage());
        return dgUser;

    }
    @Override
    public Boolean addUserData() throws Exception {
        for(int i=0;i<3000;i++){
            dgUserService.saveDgUser(this.genDgUser());
        }
        return Boolean.TRUE;
    }
}
