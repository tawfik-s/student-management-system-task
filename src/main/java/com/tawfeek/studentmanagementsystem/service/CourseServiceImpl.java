package com.tawfeek.studentmanagementsystem.service;

import com.tawfeek.studentmanagementsystem.entity.Course;
import com.tawfeek.studentmanagementsystem.entity.Student;
import com.tawfeek.studentmanagementsystem.entity.Teacher;
import com.tawfeek.studentmanagementsystem.repository.CourseRepo;
import com.tawfeek.studentmanagementsystem.repository.StudentRepo;
import com.tawfeek.studentmanagementsystem.repository.TeacherRepo;
import com.tawfeek.studentmanagementsystem.service.dto.course.CourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Override
    public Course addCourse(CourseRequest courseRequest) {
        Course course = Course.builder()
                .name(courseRequest.getName())
                .teacher(teacherRepo.findById(courseRequest.getTeacherId()).orElse(null)).build();
        return courseRepo.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }

    @Override
    public Course updateCourse(CourseRequest courseRequest) {
        Course course = courseRepo.findById(courseRequest.getId()).orElseThrow();
        course.setName(courseRequest.getName());
        if (courseRequest.getTeacherId() != null)
            course.setTeacher(teacherRepo.findById(courseRequest.getTeacherId()).orElse(null));
        return courseRepo.save(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        Optional<Course> optionalCourse = courseRepo.findById(courseId);
        return optionalCourse.orElseThrow();
    }

    //todo use jpql query to make only one hit
    @Override
    public Course addStudentToCourse(Long courseId, Long studentId) {
        Course course = getCourseById(courseId);
        Student student = studentRepo.findById(studentId).orElseThrow();
        course.getRegisteredStudents().add(student);
        return courseRepo.save(course);
    }


    //todo use jpql query to make only one hit
    @Override
    public Course removeStudentFromCourse(Long courseId, Long studentId) {
        Course course = getCourseById(courseId);
        Student student = studentRepo.findById(studentId).orElseThrow();
        course.getRegisteredStudents().remove(student);
        return courseRepo.save(course);
    }
}
