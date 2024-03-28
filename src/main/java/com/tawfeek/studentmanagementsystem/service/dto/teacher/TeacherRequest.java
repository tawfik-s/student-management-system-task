package com.tawfeek.studentmanagementsystem.service.dto.teacher;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherRequest {

    private String name;

    private String email;

    private String phone;
}
