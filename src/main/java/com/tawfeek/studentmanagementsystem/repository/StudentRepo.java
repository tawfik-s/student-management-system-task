package com.tawfeek.studentmanagementsystem.repository;

import com.tawfeek.studentmanagementsystem.entity.Course;
import com.tawfeek.studentmanagementsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

public interface StudentRepo extends JpaRepository<Student,Long> {
}
