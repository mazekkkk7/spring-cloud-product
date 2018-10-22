package cn.mazekkkk.cloud.product.common;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by mazekkkk on 16/1/28.
 */
@Configuration
public class ModuleConfig implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;
    private RelaxedPropertyResolver jdbcPropertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "mybatis.");
        this.jdbcPropertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
    }

    /**
     * 事务管理
     *
     * @return
     */
    @Bean(name = "transactionManager")
    @ConditionalOnMissingBean({PlatformTransactionManager.class})
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }

    /**
     * 数据源管理
     *
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties primaryDataSourceProperties() {

        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl(jdbcPropertyResolver.getProperty("url"));
        dataSourceProperties.setUsername(jdbcPropertyResolver.getProperty("username"));
        dataSourceProperties.setPassword(jdbcPropertyResolver.getProperty("password"));
        dataSourceProperties.setDriverClassName(jdbcPropertyResolver.getProperty("driver-class-name"));
        return dataSourceProperties;
    }

    /**
     * 数据源管理
     *
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(jdbcPropertyResolver.getProperty("url"));
        //用户名
        dataSource.setUsername(jdbcPropertyResolver.getProperty("username"));
        //密码
        dataSource.setPassword(jdbcPropertyResolver.getProperty("password"));
        dataSource.setInitialSize(10);
        dataSource.setMaxActive(50);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        dataSource.setPoolPreparedStatements(false);
        dataSource.setDefaultAutoCommit(false);
        return dataSource;
    }

    /**
     * Sqlsession管理数据源
     *
     * @return
     * @throws Exception
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setTypeAliasesPackage(propertyResolver.getProperty("type-aliases-package"));
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(propertyResolver.getProperty("mapper-locations")));
        sessionFactoryBean.setConfigurationProperties(getMyBatisProperties());

        PageHelper pageHelper = new PageHelper();
        pageHelper.setProperties(getPageHelperProperties());
        sessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});

        return sessionFactoryBean.getObject();
    }

    /**
     * 构建pageHelper配置
     *
     * @return
     */
    public Properties getPageHelperProperties() {
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("params", "count=countSql");
        return properties;
    }

    /**
     * 构建Mybatis配置
     *
     * @return
     */
    public Properties getMyBatisProperties() {
        Properties properties = new Properties();
        properties.setProperty("cacheEnabled", "true");

        return properties;
    }

    /**
     * Mybatis通用Mapper配置
     *
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("cn.mazekkkk.cloud.product.dao.mapper");
        Properties propertiesMapper = new Properties();
        propertiesMapper.setProperty("mappers", "tk.mybatis.mapper.common.Mapper");
        propertiesMapper.setProperty("IDENTITY", "SELECT REPLACE(UUID(),'-','')");
        propertiesMapper.setProperty("ORDER", "BEFORE");
        mapperScannerConfigurer.setProperties(propertiesMapper);
        return mapperScannerConfigurer;
    }

}
