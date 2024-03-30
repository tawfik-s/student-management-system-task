package com.tawfeek.studentmanagementsystem.repository;

import com.tawfeek.studentmanagementsystem.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface QuizRepo extends JpaRepository<Quiz,Long> {
}
