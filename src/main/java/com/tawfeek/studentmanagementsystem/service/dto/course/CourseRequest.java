package com.tawfeek.studentmanagementsystem.service.dto.course;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {

    private Long id;

    private String name;

    private Long teacherId;
}
