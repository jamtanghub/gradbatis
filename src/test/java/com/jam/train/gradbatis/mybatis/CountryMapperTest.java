package com.jam.train.gradbatis.mybatis;

import com.jam.train.gradbatis.mybatis.domain.Country;
import com.jam.train.gradbatis.mybatis.domain.SysUser;
import com.jam.train.gradbatis.mybatis.mapper.CountryMapper;
import com.jam.train.gradbatis.mybatis.mapper.SysUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.function.Consumer;

public class CountryMapperTest  {

    private static SqlSessionFactory sqlSessionFactory;


    @BeforeClass
    public static void init(){
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findOne(){
       SqlSession sqlSession =  sqlSessionFactory.openSession();
       try{
           Country country =  sqlSession.selectOne("com.jam.train.gradbatis.mybatis.mapper.CountryMapper.selectByPrimaryKey",1);
           System.out.println(country.getCountryname());
       }finally {
           sqlSession.close();
       }
    }

    @Test
    public void findOne2(){
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        try{
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
            Country country = countryMapper.selectByPrimaryKey(1);
            System.out.println(country.getCountryname());


            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            SysUser user = sysUserMapper.selectByPrimaryKey(1L);
            System.out.println(user.getUserName());


        }finally {
            sqlSession.close();
        }
    }


    @Test
    public void allUsers(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            SysUserMapper sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
            List<SysUser> list =  sysUserMapper.selectAll();

            //Lambda表达式
            list.forEach((user)->{
                System.out.println(user.getUserName());
            });

            list.forEach(new Consumer<SysUser>() {
                @Override
                public void accept(SysUser sysUser) {
                    System.out.println(sysUser.getUserName());
                }
            });


        }finally {
            sqlSession.close();
        }
    }


    private void printList(List<Country> countryList){
        for(Country country:countryList){
            System.out.println(country.getCountryname());
        }
    }

}
