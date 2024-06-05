package com.ogabrielfelipe.cursos.modules.Course.dto;

import com.ogabrielfelipe.cursos.modules.Course.CourseActivedEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CourseDTO {
    private String name;
    private String category;
}
