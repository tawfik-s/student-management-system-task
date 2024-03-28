package com.tawfeek.studentmanagementsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * assumption
 * it's a management system, so we will use quiz entity to record each student mark in the quiz
 *
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    @OneToMany
    private List<StudentQuizScore> studentQuizScoreList;

}
