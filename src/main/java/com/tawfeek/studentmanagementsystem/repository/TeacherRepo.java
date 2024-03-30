package com.tawfeek.studentmanagementsystem.repository;

import com.tawfeek.studentmanagementsystem.entity.Course;
import com.tawfeek.studentmanagementsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {

}
