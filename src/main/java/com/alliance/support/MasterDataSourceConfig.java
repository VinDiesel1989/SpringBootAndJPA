/**
 * 
 */
package com.alliance.support;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qW
 * @description <em style="color='gray'">主数据源配置</em>
 * @date 2016年3月2日
 * @version 1.0.0
 */
@Configuration
public class MasterDataSourceConfig {

	@Bean(name = "masterDataSource")
	@Qualifier("masterDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.master")
	public DataSource masterDataSource(){
		return DataSourceBuilder.create().build();
	}
}
