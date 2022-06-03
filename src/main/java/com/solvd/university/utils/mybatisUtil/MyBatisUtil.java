package com.solvd.university.utils.mybatisUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

import static com.solvd.university.utils.jaxb.JaxbUtils.PATH_NAME;

public class MyBatisUtil {
    public final static String MYBATIS_CONFIG = PATH_NAME + "MyBatis.config.xml";
    private static SqlSessionFactory sqlSessionFactory;

    static {
        InputStream inputStream;
        try {
            inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
