package com.tawfeek.studentmanagementsystem.service;


import com.tawfeek.studentmanagementsystem.entity.Teacher;
import com.tawfeek.studentmanagementsystem.service.dto.teacher.TeacherRequest;

public interface TeacherService {


    Teacher addTeacher(TeacherRequest teacherRequest);

    void removeTeacher(Long teacherId);

    Teacher updateTeacher(Teacher teacher);

    Teacher getTeacherById(Long teacherId);

}
