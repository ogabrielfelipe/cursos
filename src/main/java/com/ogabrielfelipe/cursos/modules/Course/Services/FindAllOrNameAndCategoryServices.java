package com.ogabrielfelipe.cursos.modules.Course.Services;

import com.ogabrielfelipe.cursos.modules.Course.CourseEntity;
import com.ogabrielfelipe.cursos.modules.Course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FindAllOrNameAndCategoryServices {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute(String name, String category){
        if(name == null && category == null) {
            return this.courseRepository.findAll();
        }
        List<CourseEntity> courseEntities = new ArrayList<>();

        Optional<List<CourseEntity>> courses = this.courseRepository.findByNameAndCategory(name, category);
        courseEntities = courses.orElse(Collections.emptyList());



        return courseEntities;
    }
}
