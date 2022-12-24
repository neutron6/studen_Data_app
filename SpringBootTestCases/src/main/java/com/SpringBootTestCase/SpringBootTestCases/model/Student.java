package com.SpringBootTestCase.SpringBootTestCases.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue
    private int studentId;

    private String studentPassword;

    private String studentName;

    private String studentAddress;

    private long studentContactNumber;

//    private List<StudentMarks> studentMarksList;
//
//    private List<StudentAverage> studentAverageList;


}
