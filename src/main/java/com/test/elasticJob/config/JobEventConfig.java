/**
 * @author liaoyubo
 * @version 1.0
 * @date 2018/5/3
 * @description
 */
package com.test.elasticJob.config;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class JobEventConfig {

    @Resource
    private DataSource dataSource;

    @Bean(name = "jobEventRdbConfiguration")
    public JobEventConfiguration jobEventConfiguration() {
        return new JobEventRdbConfiguration(dataSource);
    }
}
