package com.example.tk.mybatis.service;

import com.example.tk.mybatis.FeaturedGoods;
import com.example.tk.mybatis.FeaturedGoodsMapper;
import com.example.tk.mybatis.TopGoodsSummary;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class FeaturedGoodsMapperTest {
    private static FeaturedGoodsMapper mapper;

    @BeforeClass
    public static void init() throws Exception {
        Provider provider = new Provider();
        SqlSessionFactory sqlSessionFactory = provider.getSqlSessionFactory();
        mapper = sqlSessionFactory.openSession(ExecutorType.SIMPLE, true).getMapper(FeaturedGoodsMapper.class);
    }

    @Test
    public void useModel() {
        FeaturedGoods query = new FeaturedGoods();
        query.setFeaturedId("pdd.keywords.hr.6");
        List<FeaturedGoods> r = mapper.select(query);
        System.out.println(r);
    }

    @Test
    public void useExample() {
        PageHelper.offsetPage(0, 2);
        Example example = new Example(FeaturedGoods.class);
        example.createCriteria().andEqualTo("featuredId", "pdd.keywords.hr.6");
        List<FeaturedGoods> r = mapper.selectByExample(example);
        System.out.println(r.size());
    }

    @Test
    public void batch() {
        PageHelper.offsetPage(0, 2);
        FeaturedGoods query = new FeaturedGoods();
        query.setFeaturedId("pdd.keywords.hr.6");
        List<FeaturedGoods> r = mapper.select(query);
        for (FeaturedGoods goods : r) {
            System.out.printf("sku %s", goods.getSkuId());
        }

        for (FeaturedGoods goods : r) {
            goods.setSalesVolume("1001");
        }

        mapper.insertForUpdateBatch(r);
    }

    @Test
    public void top() {
        List<TopGoodsSummary> r = mapper.selectTopGoods("1", "pdd.keywords.hr.6");
        System.out.println(r);
    }
}
