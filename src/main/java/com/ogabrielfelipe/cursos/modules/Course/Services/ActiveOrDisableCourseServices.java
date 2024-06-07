package com.ogabrielfelipe.cursos.modules.Course.Services;

import com.ogabrielfelipe.cursos.modules.Course.CourseActivedEnum;
import com.ogabrielfelipe.cursos.modules.Course.CourseEntity;
import com.ogabrielfelipe.cursos.modules.Course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ActiveOrDisableCourseServices {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID id) throws Exception {
        CourseEntity course = this.courseRepository.findById(id).orElse(null);

        if(course == null) throw new Exception();

        course.setActive(course.getActive() == CourseActivedEnum.TRUE ? CourseActivedEnum.FALSE : CourseActivedEnum.TRUE);

        return this.courseRepository.save(course);


    }
}
