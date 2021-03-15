package io.geekidea.springbootplus.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author:li.taojun
 * @Date: 2021/3/15,11:47
 * @Version:1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "poc.item")
public class PocItemProperties {

    /**
     * 是否活跃用户.  0  活跃用户，  1  睡眠客户
     */
    private Integer userFlag;

    /**
     * 活跃用户比率，如配置10，即活跃用户为睡眠用户的10倍
     */
    private Integer activeUserRate;
}
