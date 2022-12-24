package com.SpringBootTestCase.SpringBootTestCases.service;

import com.SpringBootTestCase.SpringBootTestCases.dao.StudentDaoImpl;
import com.SpringBootTestCase.SpringBootTestCases.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl {

    @Autowired
    StudentDaoImpl studentDaoImpl;

    public Student Register(Student student) {

        return studentDaoImpl.Register(student);
    }

    public Boolean SignIn(String studentName, String studentPassword) {
        return studentDaoImpl.SignIn(studentName, studentPassword);
    }


    public List<Student> getDataByStudentId(int studentId) {

        return studentDaoImpl.getDataByStudentId(studentId);
    }

    public List<Student> getDataByStudentName(String studentName) {
        return studentDaoImpl.getDataByStudentName(studentName);
    }

    public List<Student> getAllData() {

        return studentDaoImpl.getAllData();
    }

    public List<Student> sortByStudentId() {

        return studentDaoImpl.sortByStudentId();
    }

    public List<Student> sortByStudentName() {

        return studentDaoImpl.sortByStudentName();
    }

    public List<Student> sortByStudentAddress() {

        return studentDaoImpl.sortByStudentAddress();
    }

//    public List<Student> sortByStudentMarksList() {
//
//        return studentDaoImpl.sortByStudentMarksList();
//    }
//
//    public List<Student> sortBystudentAverageList() {
//        return studentDaoImpl.sortBystudentAverageList();
//    }
}
