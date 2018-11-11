package com.fengtao.usercenterservice;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 功能描述：用户中心配置类
 *
 * @Auther: GQlofe
 * @Date: 2018/9/16 22:02
 */
@Data
@Configuration
public class UserCenterServiceConfigration {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username; //用户名
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${druid.initial-size}")
    private Integer initialSize; //初始化时建立物理连接的个数
    @Value("${druid.maxActive}")
    private Integer maxActive; //最大连接池数量
    @Value("${druid.min-idle}")
    private Integer minIdle; //最小连接池数量
    @Value("${druid.max-wait}")
    private Integer maxWait; //获取连接时最大等待时间，单位毫秒。
    @Value("druid.validation-query")
    private String validationQuery; //用来检测连接是否有效的sql
    @Value("${druid.test-on-borrow}")
    private boolean testOnBorrow; //申请连接时执行validationQuery检测连接是否有效
    @Value("${druid.test-while=idle}")
    private boolean testWhileIdle; //建议配置为true，不影响性能，并且保证安全性。
    @Value("${druid.pool-prepared-statements}")
    private boolean poolPreparedStatements; //是否缓存preparedStatement，也就是PSCache



    //destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);//用户名
        dataSource.setPassword(password);//密码
        dataSource.setDriverClassName(driver);
        dataSource.setInitialSize(initialSize);//初始化时建立物理连接的个数
        dataSource.setMaxActive(maxActive);//最大连接池数量
        dataSource.setMinIdle(minIdle);//最小连接池数量
        dataSource.setMaxWait(maxWait);//获取连接时最大等待时间，单位毫秒。
        dataSource.setValidationQuery(validationQuery);//用来检测连接是否有效的sql
        dataSource.setTestOnBorrow(testOnBorrow);//申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(testWhileIdle);//建议配置为true，不影响性能，并且保证安全性。
        dataSource.setPoolPreparedStatements(poolPreparedStatements);//是否缓存preparedStatement，也就是PSCache
        return dataSource;
    }
}
