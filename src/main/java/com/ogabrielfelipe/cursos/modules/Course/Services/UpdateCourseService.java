package com.ogabrielfelipe.cursos.modules.Course.Services;

import com.ogabrielfelipe.cursos.modules.Course.CourseEntity;
import com.ogabrielfelipe.cursos.modules.Course.CourseRepository;
import com.ogabrielfelipe.cursos.modules.Course.dto.CreateCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class UpdateCourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID id, CreateCourseDTO courseDTO) throws Exception {

        CourseEntity courseEntity = this.courseRepository.findById(id).orElse(null);
        if (courseEntity == null) throw new Exception();

        courseEntity.setName(courseDTO.name().isBlank() ? courseEntity.getName() : courseDTO.name());
        courseEntity.setCategory(courseDTO.category().isBlank() ? courseEntity.getCategory() : courseDTO.category());

        this.courseRepository.save(courseEntity);

        return courseEntity;
    }
}
