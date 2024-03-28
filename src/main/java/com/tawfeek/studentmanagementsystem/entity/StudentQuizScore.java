package com.tawfeek.studentmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * assumption to add students quiz score in the database
 *
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class StudentQuizScore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Student student;

    private Long score;
}
