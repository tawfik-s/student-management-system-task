package com.tawfeek.studentmanagementsystem.controller;

import com.tawfeek.studentmanagementsystem.entity.Course;
import com.tawfeek.studentmanagementsystem.service.CourseService;
import com.tawfeek.studentmanagementsystem.service.dto.course.CourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {


    private CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody CourseRequest courseRequest) {
        Course addedCourse = courseService.addCourse(courseRequest);
        return new ResponseEntity<>(addedCourse, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Course> updateCourse(@RequestBody CourseRequest courseRequest) {
        Course updatedCourse = courseService.updateCourse(courseRequest);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId) {
        Course course = courseService.getCourseById(courseId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/{courseId}/addStudent/{studentId}")
    public ResponseEntity<Course> addStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        Course updatedCourse = courseService.addStudentToCourse(courseId, studentId);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    @PostMapping("/{courseId}/removeStudent/{studentId}")
    public ResponseEntity<Course> removeStudentFromCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        Course updatedCourse = courseService.removeStudentFromCourse(courseId, studentId);
        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }
}