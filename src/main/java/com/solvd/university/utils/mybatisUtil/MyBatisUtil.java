package com.solvd.university.utils.mybatisUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

import static com.solvd.university.utils.jaxb.JaxbUtils.PATH_NAME;

public class MyBatisUtil {

    public final static String MYBATIS_CONFIG = "Mybatis-config.xml"; //PATH_NAME +
    private static SqlSession session;

    public static SqlSession getSession() {
        try {
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
            session = sqlMapper.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }

    public static SqlSessionFactory sessionFactory() {
        SqlSessionFactory sessionFactory = null;
        try {
            Reader reader = Resources.getResourceAsReader(MYBATIS_CONFIG);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public static void createMapper(String link, Object obj) {
        getSession();
        try {
            session.insert(link + ".create", obj);
            session.commit();
        } finally {
            session.close();
        }
    }

    public static void updateMapper(String link, Object entity) {
        getSession();
        if (session != null) {
            try {
                session.update(link + ".update", entity);
            } finally {
                session.close();
            }
        }
    }

    public static void deleteMapper(String link, String id) {
        getSession();
        if (session != null) {
            try {
                session.delete(link + ".delete", id);
            } finally {
                session.close();
            }
        }
    }
}

