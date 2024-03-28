package com.tawfeek.studentmanagementsystem.service;

import com.tawfeek.studentmanagementsystem.entity.Course;
import com.tawfeek.studentmanagementsystem.service.dto.course.CourseRequest;

public interface CourseService {

    Course addCourse(CourseRequest courseRequest);

    void deleteCourse(Long id);

    Course updateCourse(CourseRequest courseRequest);

    Course getCourseById(Long courseId);

    Course addStudentToCourse(Long courseId,Long studentId);

    Course removeStudentFromCourse(Long courseId,Long studentId);
}
