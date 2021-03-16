/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.geekidea.springbootplus.scheduled;

import dg.bestv.dgpoc.dto.DgOpItemDto;
import dg.bestv.dgpoc.service.UserOperateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author geekidea
 * @date 2020/3/16
 **/
@Slf4j
@Component
@EnableScheduling // 2.开启定时任务
public class HelloScheduled {

    @Autowired
    private UserOperateService userOperateService;
    /**
     * 每小时执行一次
     */
    @Scheduled(cron = "0 0/1 * * * ? ")
    public void hello() throws Exception {
        userOperateService.randOperateBySelectType(0);
        userOperateService.randOperateBySelectType(1);
        userOperateService.runByOrder();
        log.debug("HelloScheduled...");
    }

    public void insertUserData() throws Exception {
        if(!DgOpItemDto.userDataSign){
            userOperateService.addUserData();
            DgOpItemDto.userDataSign = Boolean.TRUE;
        }
    }


}
