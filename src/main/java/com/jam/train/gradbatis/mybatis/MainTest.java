package com.jam.train.gradbatis.mybatis;

import com.jam.train.gradbatis.mybatis.domain.Country;
import com.jam.train.gradbatis.mybatis.mapper.CountryMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MainTest {

    public static void main(String[] args) {

        try {
            // 读取mybatis-config.xml文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            // 初始化mybatis，创建SqlSessionFactory类的实例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            // 创建Session实例
            SqlSession session = sqlSessionFactory.openSession();

            // 获得xml映射文件中定义的操作语句
            Country c = session.selectOne("com.jam.train.gradbatis.mybatis.mapper.CountryMapper.selectByPrimaryKey", 1);
            System.out.println(c.getCountrycode());

            // 获得mapper接口的代理对象
            CountryMapper countryMapper = session.getMapper(CountryMapper.class);
            Country country = countryMapper.selectByPrimaryKey(1);
            System.out.println(country.getCountryname());

            // 提交事务
            session.commit();
            // 关闭Session
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
