package com.tawfeek.studentmanagementsystem.repository;

import com.tawfeek.studentmanagementsystem.entity.Course;
import com.tawfeek.studentmanagementsystem.entity.Student;
import com.tawfeek.studentmanagementsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course,Long> {


    List<Course> findCoursesByTeacher(Teacher teacher);

    @Query("SELECT c FROM Course c WHERE :student MEMBER OF c.registeredStudents")
    List<Course> getStudentCourses(@Param("student") Student student);

}
