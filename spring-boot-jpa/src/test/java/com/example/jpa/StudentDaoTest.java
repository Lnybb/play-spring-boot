package com.example.jpa;

import com.example.jpa.dao.GenderType;
import com.example.jpa.dao.Student;
import com.example.jpa.dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @author zyd
 * @date 2019/04/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApp.class)
public class StudentDaoTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(StudentDaoTest.class);

    @Autowired
    private StudentDao studentDao;

    @Test
    public void f1() {
        Student student = new Student();
        student.setName("zyd");
        student.setGender(GenderType.MALE);
        student.setCreatedAt(new Date());
        student.setUpdatedAt(new Date());
        studentDao.save(student);
        LOGGER.info("save success");
        Student byName = studentDao.findByName("zyd");
        LOGGER.info("query success, {}", byName);
    }

    @Test
    public void f2() {
        List<Student> students = studentDao.findAllByName("zyd 1");
        LOGGER.info("students: {}", students);
    }

}
