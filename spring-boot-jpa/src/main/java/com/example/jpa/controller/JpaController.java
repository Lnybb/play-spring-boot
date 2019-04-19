package com.example.jpa.controller;

import com.example.jpa.dao.GenderType;
import com.example.jpa.dao.Student;
import com.example.jpa.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zyd
 * @date 2019/04/18
 */
@RestController
@RequestMapping("/jap")
public class JpaController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping("save.student")
    public ResponseEntity saveStudent() {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Student student = new Student();
            studentList.add(student);
            student.setName("zyd " + i);
            student.setGender(GenderType.MALE);
            student.setCreatedAt(new Date());
            student.setUpdatedAt(new Date());
        }
        studentDao.saveAll(studentList);

        return ResponseEntity.ok("OK");
    }

}
