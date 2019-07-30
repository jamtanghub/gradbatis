package com.jam.train.gradbatis.mybatis;

import com.jam.train.gradbatis.mybatis.domain.Admin;
import com.jam.train.gradbatis.mybatis.mapper.AdminMapper;
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
//            Admin p = session.selectOne("com.jam.train.gradbatis.mybatis.mapper.AdminMapper.selectByPrimaryKey", 1);
//            System.out.println(p);
//            System.out.println(p.getUsername());

            // 获得mapper接口的代理对象
            AdminMapper pm = session.getMapper(AdminMapper.class);
            // 直接调用接口的方法，查询id为1的Peson数据
            Admin p2 = pm.selectByPrimaryKey(1);
            // 打印Peson对象
            System.out.println(p2);
            // 打印Person对象关联的Card对象
            System.out.println(p2.getUsername());

            // 提交事务
            session.commit();
            // 关闭Session
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
