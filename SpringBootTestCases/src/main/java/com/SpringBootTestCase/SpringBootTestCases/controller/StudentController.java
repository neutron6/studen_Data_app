package com.SpringBootTestCase.SpringBootTestCases.controller;

import com.SpringBootTestCase.SpringBootTestCases.exception.RegisterException;
import com.SpringBootTestCase.SpringBootTestCases.exception.SortException;
import com.SpringBootTestCase.SpringBootTestCases.exception.StudentRecordNotFoundException;
import com.SpringBootTestCase.SpringBootTestCases.model.Student;
import com.SpringBootTestCase.SpringBootTestCases.service.StudentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v4")
@Slf4j
public class StudentController {

    @Autowired
    StudentServiceImpl studentServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<Student> Register(@RequestBody Student student) throws RegisterException {

        if (studentServiceImpl.Register(student) == null) {
            throw new RegisterException("** [either you entered wrong info] **");
        }

        log.info("#######REGISTER SUCCESS #######" + Register(student));
        return ResponseEntity.ok(studentServiceImpl.Register(student));
    }

    @GetMapping("/signin/{studentName}/{studentPassword}")
    public ResponseEntity<Boolean> SignIn(@PathVariable String studentName, String studentPassword) throws StudentRecordNotFoundException {

//        if (studentServiceImpl.SignIn(studentName) == null && studentServiceImpl.SignIn(studentPassword) == null) {
//            throw new StudentRecordNotFoundException("** [student record you have entered is either not in database or deleted] **");
//        }

        log.info("*****SIGN IN SUCCESS*****" + SignIn(studentName,studentPassword));

        return ResponseEntity.ok(studentServiceImpl.SignIn(studentName, studentPassword));
    }


    @GetMapping("/getbyid/{studentId}")
    public ResponseEntity<List<Student>> getDataByStudentId(@PathVariable int studentId) throws StudentRecordNotFoundException {


        log.info("#####GET DATA ####" + getDataByStudentId(studentId));
        return ResponseEntity.ok(studentServiceImpl.getDataByStudentId(studentId));
    }

    @GetMapping("/getbyname/{studentName}")
    public ResponseEntity<List<Student>> getDataByStudentName(@PathVariable String studentName) {

        log.info("####GET DATA BY NAME####" + getDataByStudentName(studentName));
        return ResponseEntity.ok(studentServiceImpl.getDataByStudentName(studentName));
    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Student>> getAllData() {
        return ResponseEntity.ok(studentServiceImpl.getAllData());
    }

    @GetMapping("/sortbyid")
    public ResponseEntity<List<Student>> sortByStudentId() throws SortException {
        if (studentServiceImpl.sortByStudentId() != sortByStudentId()) {
            throw new SortException("** [ ENTERED WRONG CREDENTIALS ] **");
        }
        log.info("#####SORT BY ID#####");
        return ResponseEntity.ok(studentServiceImpl.sortByStudentId());
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Student>> sortByStudentName() {
        log.info("#####SORT BY NAME#####");
        return ResponseEntity.ok(studentServiceImpl.sortByStudentName());
    }

    @GetMapping("/sortbyaddress")
    public ResponseEntity<List<Student>> sortByStudentAddress() {
        log.info("#####SORT BY ADDRESS#####");
        return ResponseEntity.ok(studentServiceImpl.sortByStudentAddress());
    }

//    @GetMapping("/sortbymarks")
//    public ResponseEntity<List<Student>> sortByStudentMarksList() {
//        return ResponseEntity.ok(studentServiceImpl.sortByStudentMarksList());
//    }
//
//    @GetMapping("/sortbyave")
//    public ResponseEntity<List<Student>> sortBystudentAverageList() {
//        return ResponseEntity.ok(studentServiceImpl.sortBystudentAverageList());
//    }
}
