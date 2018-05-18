/**
 * @author liaoyubo
 * @version 1.0
 * @date 2018/5/3
 * @description
 */
package com.test.elasticJob.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@ConditionalOnExpression("'${regCenter.serverList}'.length() > 0")
@Component
public class ElasticJobConfig {
    
    @Bean(initMethod = "init",name = "regCenter")
    public ZookeeperRegistryCenter regCenter(@Value("${regCenter.serverList}") final String serverList, @Value("${regCenter.namespace}") final String namespace) {
        ZookeeperConfiguration zookeeperConfiguration = new ZookeeperConfiguration(serverList, namespace);
        zookeeperConfiguration.setMaxRetries(5);
        zookeeperConfiguration.setConnectionTimeoutMilliseconds(5000);
        return new ZookeeperRegistryCenter(zookeeperConfiguration);
    }
}
