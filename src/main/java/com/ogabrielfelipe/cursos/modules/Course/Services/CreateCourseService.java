package com.ogabrielfelipe.cursos.modules.Course.Services;

import com.ogabrielfelipe.cursos.modules.Course.CourseActivedEnum;
import com.ogabrielfelipe.cursos.modules.Course.CourseEntity;
import com.ogabrielfelipe.cursos.modules.Course.CourseRepository;
import com.ogabrielfelipe.cursos.modules.Course.dto.CourseDTO;
import com.ogabrielfelipe.cursos.modules.Course.dto.CreateCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CreateCourseDTO createCourseDTO){

        CourseEntity course = new CourseEntity();
        course.setName(createCourseDTO.name());
        course.setCategory(createCourseDTO.category());
        course.setActive(CourseActivedEnum.TRUE);

        return this.courseRepository.save(course);
    }
}
