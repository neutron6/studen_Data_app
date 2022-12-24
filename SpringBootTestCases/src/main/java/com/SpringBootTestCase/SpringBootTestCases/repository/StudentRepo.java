package com.SpringBootTestCase.SpringBootTestCases.repository;

import com.SpringBootTestCase.SpringBootTestCases.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    public List<Student> findByStudentName(String studentName);

    public List<Student> findByStudentId(int studentId);

//    public List<Student> FindByUsingStudentAverageList(double studentAverageList);
}
