package com.ogabrielfelipe.cursos.modules.Course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {
    Optional<List<CourseEntity>> findByNameAndCategory(String name, String category);
}
