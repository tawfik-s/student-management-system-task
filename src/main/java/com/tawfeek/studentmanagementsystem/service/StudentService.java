package com.tawfeek.studentmanagementsystem.service;


import com.tawfeek.studentmanagementsystem.entity.Student;
import com.tawfeek.studentmanagementsystem.service.dto.course.CourseResponse;
import com.tawfeek.studentmanagementsystem.service.dto.student.StudentRequest;

import java.util.List;

public interface StudentService {

    //crud

    Student addStudent(StudentRequest studentRequest);

    void removeStudent(Long studentId);

    Student updateStudent(Student student);

    Student getStudentById(Long studentId);

    List<CourseResponse> getStudentCourses(Long studentId);

}
