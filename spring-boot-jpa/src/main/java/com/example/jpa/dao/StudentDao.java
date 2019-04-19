package com.example.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyd
 * @date 2019/04/04
 */
@Repository
public interface StudentDao extends JpaRepository<Student, String> {

    Student findByName(String name);

    List<Student> findAllByName(String name);

}
