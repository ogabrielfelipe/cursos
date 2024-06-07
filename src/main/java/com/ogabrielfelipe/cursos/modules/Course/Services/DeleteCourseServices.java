package com.ogabrielfelipe.cursos.modules.Course.Services;

import com.ogabrielfelipe.cursos.modules.Course.CourseEntity;
import com.ogabrielfelipe.cursos.modules.Course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCourseServices {

    @Autowired
    private CourseRepository courseRepository;


    public String execute(UUID id) throws Exception {
        CourseEntity course = this.courseRepository.findById(id).orElse(null);
        this.courseRepository.deleteById(id);

        if (course == null) {
            throw new Exception();
        };
        return course != null ? course.getId().toString() : null;
    }
}
