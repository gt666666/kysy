package com.sygs.config.databases;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;
@Configuration
@MapperScan(basePackages = "com.sygs.dao.sqlserver", sqlSessionFactoryRef = "sqlserverSqlSessionFactory")
public class DbSqlServerConfig {

    @Bean(name = "sqlserverDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.sqlserver")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "sqlserverSqlSessionFactory")
    public SqlSessionFactory basicSqlSessionFactory(@Qualifier("sqlserverDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        //factoryBean.setTypeAliasesPackage("com.sygs.dao.sqlserver");
        factoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/sqlserver/**/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = "sqlserverTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("sqlserverDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlserverSqlSessionTemplate")
    public SqlSessionTemplate sqlserverSqlSessionTemplate(
            @Qualifier("sqlserverSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
