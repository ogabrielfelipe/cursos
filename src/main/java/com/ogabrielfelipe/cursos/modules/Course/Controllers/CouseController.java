package com.ogabrielfelipe.cursos.modules.Course.Controllers;

import com.ogabrielfelipe.cursos.modules.Course.CourseEntity;
import com.ogabrielfelipe.cursos.modules.Course.Services.*;
import com.ogabrielfelipe.cursos.modules.Course.dto.CreateCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("")
public class CouseController {

    @Autowired
    private CreateCourseService createCourseService;

    @Autowired
    private FindAllOrNameAndCategoryServices findAllOrNameAndCategoryServices;

    @Autowired
    private UpdateCourseService updateCourseService;

    @Autowired
    private DeleteCourseServices deleteCourseServices;

    @Autowired
    private ActiveOrDisableCourseServices activeOrDisableCourseServices;

    @PostMapping("/cursos")
    public ResponseEntity<CourseEntity> createCourse(@RequestBody CreateCourseDTO courseDTO){
        return ResponseEntity.ok().body(this.createCourseService.execute(courseDTO));
    }

    @GetMapping("/cursos")
    public List<CourseEntity> getAllCourses(@RequestParam(required = false) String name, String category){
        return this.findAllOrNameAndCategoryServices.execute(name, category);
    }

    @PutMapping("/cursos/{id}")
    public ResponseEntity<CourseEntity> updateCourse(@RequestBody CreateCourseDTO courseDTO, @PathVariable String id){
        try {
            return ResponseEntity.ok().body(this.updateCourseService.execute(UUID.fromString(id), courseDTO));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }

    }

    @DeleteMapping("/cursos/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable String id){
        try {
            var courseId = this.deleteCourseServices.execute(UUID.fromString(id));
            return ResponseEntity.ok().body(courseId);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/cursos/{id}/active")
    public ResponseEntity<Object> activateCourse(@PathVariable String id){
        try {
            var result = this.activeOrDisableCourseServices.execute(UUID.fromString(id));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
