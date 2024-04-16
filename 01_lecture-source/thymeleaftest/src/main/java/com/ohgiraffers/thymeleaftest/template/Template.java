package com.ohgiraffers.thymeleaftest.template;

import com.ohgiraffers.thymeleaftest.common.MenuMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Template {

    @Value("${driver}")
    private static String driver;
    @Value("${url}")
    private static String url;
    @Value("${username}")
    private static String user;
    @Value("${password}")
    private static String pass;

    private static SqlSessionFactory sf;

    public static SqlSession getSqlSession(){
        if(sf==null){
            Environment environment = new Environment("dev",new JdbcTransactionFactory(),new PooledDataSource(driver, url,user,pass));
            Configuration configuration = new Configuration(environment);
            configuration.addMapper(MenuMapper.class);
            sf = new SqlSessionFactoryBuilder().build(configuration);

        }
        return sf.openSession(false );
    }

}
