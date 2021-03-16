package dg.bestv.dgpoc.component;

import dg.bestv.dgpoc.consts.OrderStatusEnum;
import dg.bestv.dgpoc.consts.UserOperateType;
import dg.bestv.dgpoc.dto.DgOpItemDto;
import dg.bestv.dgpoc.dto.DgOperateLogDto;
import dg.bestv.dgpoc.dto.DgOrderDto;
import dg.bestv.dgpoc.dto.DgRuleDto;
import dg.bestv.dgpoc.entity.DgOperateLog;
import dg.bestv.dgpoc.entity.DgOrder;
import dg.bestv.dgpoc.entity.DgRule;
import org.apache.logging.log4j.util.StringBuilders;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * @Author:li.taojun
 * @Date: 2021/3/15,14:21
 * @Version:1.0
 */
@Component
public class DgGoodsBuilder {

    /**
     * 通过用户操作数据，构造订单数据
     * @param dgOpItemDto
     * @return
     */
    public DgOrderDto genDgOrderDto(DgOpItemDto dgOpItemDto){
        Random random = new Random();
        DgOrderDto dgOrderDto = new DgOrderDto();
        dgOrderDto.setItemid(dgOpItemDto.getItemid());
        dgOrderDto.setUid(dgOpItemDto.getUid());
        dgOrderDto.setGroup1(dgOpItemDto.getGroup1());
        dgOrderDto.setGroup2(dgOpItemDto.getGroup2());
        //TODO 3可配置
        dgOrderDto.setOqty(dgOpItemDto.getOqty());
        dgOrderDto.setOamt(dgOpItemDto.getOamt());
        dgOrderDto.setOstatus(OrderStatusEnum.ALREADY_ORDER.getMessage());
        dgOrderDto.setOtime(genOtime());
        dgOrderDto.setUtime(dgOrderDto.getOtime());
        return dgOrderDto;
    }

    Date genOtime(){
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.MONDAY,calendar.get(Calendar.MONDAY)-1);
        return calendar.getTime();
    }

    public DgOperateLogDto genDgOperateLog(DgOrderDto dgOrderDto){
        DgOperateLogDto dgOperateLog = new DgOperateLogDto();
        dgOperateLog.setOid(dgOrderDto.getOid());
        dgOperateLog.setOstatus(dgOperateLog.getOstatus());
        dgOperateLog.setUid(dgOrderDto.getUid());
        dgOperateLog.setUtime(dgOperateLog.getUtime());
        return dgOperateLog;

    }

    public DgRuleDto genDgRuleDto(DgOpItemDto dgOpItemDto){
        DgRuleDto dgRuleDto = new DgRuleDto();
        dgRuleDto.setItemid(dgOpItemDto.getItemid());
        dgRuleDto.setUid(dgOpItemDto.getUid());
        if(UserOperateType.VISIT.getValue().equals(dgOpItemDto.getOperateType())) {
            dgRuleDto.setActCnt(1);
        }
        if(UserOperateType.ADD_TO_CART.getValue().equals(dgOpItemDto.getOperateType())) {
            dgRuleDto.setCartCnt(1);
        }
        if(UserOperateType.USER_ORDER.getValue().equals(dgOpItemDto.getOperateType())) {
            dgRuleDto.setOdrCnt(1);
        }
        return dgRuleDto;
    }

    public void genDgOrder(DgOpItemDto dgOpItemDto){
        if(UserOperateType.OUT_WAREHOUSE.getValue().equals(dgOpItemDto.getOperateType())) {
            dgOpItemDto.getDgOrderDto().setOstatus(OrderStatusEnum.HAVE_OUTBOUND.getMessage());
        }else if(UserOperateType.USER_SIGN.getValue().equals(dgOpItemDto.getOperateType())){
            dgOpItemDto.getDgOrderDto().setOstatus(OrderStatusEnum.HAVE_SIGN.getMessage());
        }
        if(UserOperateType.USER_SIGN.getValue().equals(dgOpItemDto.getOperateType())){
            Long point = dgOpItemDto.getDgOrderDto().getOamt();
            dgOpItemDto.getDgOrderDto().setPoint((int)(point/100));
        }
        dgOpItemDto.getDgOrderDto().setUtime(genOtime());
    }

    public String randomGenUbth(){
        Random random = new Random();
        int year = 1985 + random.nextInt(20);
        int month = 1 + random.nextInt(12);
        int day = 1+ random.nextInt(30);
        return String.format("%s-%s-%s",new String[]{String.valueOf(year),
                                                     String.valueOf(month),
                                                     String.valueOf(day)});
    }

    public static void main(String[] args){
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));//今天的日期
        calendar.set(Calendar.MONDAY,calendar.get(Calendar.MONDAY)-1);//让日期加1
        System.out.println(calendar.get(Calendar.DATE));//加1之后的日期Top
        System.out.println(df.format(calendar.getTime()));
    }
}
