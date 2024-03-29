package com.tawfeek.studentmanagementsystem.service;

import com.tawfeek.studentmanagementsystem.entity.Teacher;
import com.tawfeek.studentmanagementsystem.repository.TeacherRepo;
import com.tawfeek.studentmanagementsystem.service.dto.teacher.TeacherRequest;
import com.tawfeek.studentmanagementsystem.service.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

public class TeacherServiceImpl implements TeacherService {

    private TeacherRepo teacherRepo;

    private TeacherMapper teacherMapper;


    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    public void setTeacherRepo(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    @Override
    public Teacher addTeacher(TeacherRequest teacherRequest) {
        return teacherRepo.save(teacherMapper.toEntity(teacherRequest));
    }

    @Override
    public void removeTeacher(Long teacherId) {
        teacherRepo.deleteById(teacherId);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        return teacherRepo.findById(teacherId).orElseThrow();
    }
}