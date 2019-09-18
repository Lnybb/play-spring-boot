package com.example.tk.mybatis.service;

import com.example.tk.mybatis.Tree;
import com.example.tk.mybatis.TreeMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

public class TreeMapperTest {
    private static TreeMapper mapper;

    @BeforeClass
    public static void init() throws Exception {
        Provider provider = new Provider();
        SqlSessionFactory sqlSessionFactory = provider.getSqlSessionFactory();
        mapper = sqlSessionFactory.openSession(ExecutorType.SIMPLE, true).getMapper(TreeMapper.class);
    }

    @Test
    public void f1() {
        List<Tree> collect = new ArrayList<>();
        Example queryRoot = new Example(Tree.class);
        queryRoot.createCriteria().andIsNull("parentId");
        List<Tree> root = mapper.selectByExample(queryRoot);
        for (Tree tree : root) {
            List<Tree> trees = queryChild(tree.getId());
            collect.addAll(trees);
        }
        System.out.println(collect);
    }

    private List<Tree> queryChild(String parentId) {
        Example example = new Example(Tree.class);
        example.createCriteria().andEqualTo("parentId", parentId);
        List<Tree> trees = mapper.selectByExample(example);
        if (trees == null || trees.isEmpty()) {
            return new ArrayList<>();
        }
        List<Tree> collect = new ArrayList<>(trees);
        for (Tree tree : trees) {
            String id = tree.getId();
            collect.addAll(queryChild(id));
        }
        return collect;
    }
}
