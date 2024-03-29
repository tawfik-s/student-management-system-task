package com.tawfeek.studentmanagementsystem.controller;

import com.tawfeek.studentmanagementsystem.entity.Teacher;
import com.tawfeek.studentmanagementsystem.service.TeacherService;
import com.tawfeek.studentmanagementsystem.service.dto.teacher.TeacherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<Teacher> addTeacher(@RequestBody TeacherRequest teacherRequest) {
        Teacher addedTeacher = teacherService.addTeacher(teacherRequest);
        return new ResponseEntity<>(addedTeacher, HttpStatus.CREATED);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<Void> removeTeacher(@PathVariable Long teacherId) {
        teacherService.removeTeacher(teacherId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher) {
        Teacher updatedTeacher = teacherService.updateTeacher(teacher);
        return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long teacherId) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }
}
