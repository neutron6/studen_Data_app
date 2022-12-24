package com.SpringBootTestCase.SpringBootTestCases.dao;

import com.SpringBootTestCase.SpringBootTestCases.model.Student;
import com.SpringBootTestCase.SpringBootTestCases.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentDaoImpl {

    @Autowired
    StudentRepo studentRepoImpl;

    public Student Register(Student student) {

        return studentRepoImpl.save(student);
    }

    public Boolean SignIn(String studentName, String studentPassword) {

        for (Student student : studentRepoImpl.findAll()) {
            if (student.getStudentName().equals(studentName) && student.getStudentPassword().equals(studentPassword)) {
                return true;
            }
        }
        return false;
    }


    public List<Student> getDataByStudentId(int studentId) {

        return studentRepoImpl.findByStudentId(studentId);
    }

    public List<Student> getDataByStudentName(String studentName) {
        return studentRepoImpl.findByStudentName(studentName);
    }

    public List<Student> getAllData() {

        return studentRepoImpl.findAll();
    }

    public List<Student> sortByStudentId() {
        return studentRepoImpl.findAll().stream().sorted(Comparator.comparingInt(Student::getStudentId)).collect(Collectors.toList());
    }

    public List<Student> sortByStudentName() {
        return studentRepoImpl.findAll().stream().sorted(Comparator.comparing(Student::getStudentName)).collect(Collectors.toList());

    }

    public List<Student> sortByStudentAddress() {
        return studentRepoImpl.findAll().stream().sorted(Comparator.comparing(Student::getStudentAddress)).collect(Collectors.toList());

    }

//    public List<Student> sortByStudentMarksList() {
//
//        return studentRepoImpl.findAll().stream().sorted((Comparator<? super Student>) sortByStudentMarksList()).collect(Collectors.toList());
//    }
//
//    public List<Student> sortBystudentAverageList() {
//
//        return studentRepoImpl.findAll().stream().sorted((Comparator<? super Student>) sortBystudentAverageList()).collect(Collectors.toList());
//    }
}
