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

    @Value("spring.datasource.url")
    private String url;
    @Value("spring.datasource.username")
    private String username; //用户名
    @Value("spring.datasource.password")
    private String password;
    @Value("spring.datasource.driver-class-name")
    private String driver;

//    @Value("druid.initial-size")
    private Integer initialSize; //初始化时建立物理连接的个数
//    @Value("druid.maxActive")
    private Integer maxActive; //最大连接池数量
//    @Value("druid.min-idle")
    private Integer minIdle; //最小连接池数量
//    @Value("druid.max-wait")
    private Integer maxWait; //获取连接时最大等待时间，单位毫秒。
    @Value("druid.validation-query")
    private String validationQuery; //用来检测连接是否有效的sql
//    @Value("druid.test-on-borrow")
    private boolean testOnBorrow; //申请连接时执行validationQuery检测连接是否有效
//    @Value("druid.test-while=idle")
    private boolean testWhileIdle; //建议配置为true，不影响性能，并且保证安全性。
//    @Value("pool-prepared-statements")
    private boolean poolPreparedStatements; //是否缓存preparedStatement，也就是PSCache



    //destroy-method="close"的作用是当数据库连接不使用的时候,就把该连接重新放到数据池中,方便下次使用调用.

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/fengtao?useUnicode=true&characterEncoding=utf-8&useSSL=true");
        dataSource.setUsername("root");//用户名
        dataSource.setPassword("root");//密码
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setInitialSize(2);//初始化时建立物理连接的个数
        dataSource.setMaxActive(20);//最大连接池数量
        dataSource.setMinIdle(0);//最小连接池数量
        dataSource.setMaxWait(60000);//获取连接时最大等待时间，单位毫秒。
        dataSource.setValidationQuery("SELECT 1");//用来检测连接是否有效的sql
        dataSource.setTestOnBorrow(false);//申请连接时执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(true);//建议配置为true，不影响性能，并且保证安全性。
        dataSource.setPoolPreparedStatements(false);//是否缓存preparedStatement，也就是PSCache
        return dataSource;
    }
}
