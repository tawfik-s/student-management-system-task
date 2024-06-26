package com.tawfeek.studentmanagementsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    //assumption each course contain one teacher
    //each teacher can teach in many courses
    @ManyToOne(cascade = {CascadeType.DETACH})
    private Teacher teacher;

    //assumption each student can enroll in many courses
    //and each course contain many students;
    @ManyToMany(cascade = {CascadeType.DETACH})
    private List<Student> registeredStudents;

    //assumption each course contain many quizzes
    @OneToMany(cascade = {CascadeType.DETACH})
    private List<Quiz> quizzes;
}
