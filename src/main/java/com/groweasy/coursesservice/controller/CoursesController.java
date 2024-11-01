package com.groweasy.coursesservice.controller;

import com.groweasy.coursesservice.controller.request.CoursesRequest;
import com.groweasy.coursesservice.controller.request.UserCoursesRequest;
import com.groweasy.coursesservice.model.Course;
import com.groweasy.coursesservice.model.UserCourse;
import com.groweasy.coursesservice.repository.CoursesRepository;
import com.groweasy.coursesservice.service.CoursesService;
import com.groweasy.coursesservice.service.UserCourseService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CoursesController {
    @Autowired
    private CoursesService coursesService;
    @Autowired
    private UserCourseService userCourseService;
    private final CoursesRepository coursesRepository;

    public CoursesController(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<List<Course>>(coursesRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Long id) {
        Course course =  coursesService.getCourseById(id);
        if(null == course){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(course);

        //return new ResponseEntity<Course>(coursesRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody CoursesRequest course) {
        try {
            validateCourse(course);
            //existsByNameAndPrice(course);
            return new ResponseEntity<Course>(coursesService.createCourse(course), HttpStatus.CREATED);
        }catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/courses/user/{userId}")
    public ResponseEntity<List<Course>> getCoursesByUserId(@PathVariable("userId") Long userId) {
        return new ResponseEntity<List<Course>>(userCourseService.getCoursesByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/courses/user/add")
    public ResponseEntity<UserCourse> addUserCourse(@RequestBody UserCoursesRequest userCoursesRequest) {
        return new ResponseEntity<UserCourse>(userCourseService.addUserCourse(userCoursesRequest.getUserId(), userCoursesRequest.getCourseId()), HttpStatus.CREATED);
    }


    private void validateCourse(CoursesRequest course){
        if(course.getName() == null || course.getName().isEmpty()){
            throw new RuntimeException("El nombre del curso es obligatorio");
        }

        if(course.getName().length() > 150){
            throw new RuntimeException("El nombre del curso no puede tener más de 50 caracteres");
        }

        if(course.getImage() == null || course.getImage().isEmpty()){
            throw new RuntimeException("El enlace de la imagen del curso es obligatoria");
        }

        if(course.getImage().length() > 200){
            throw new RuntimeException("El enlace de la imagen del curso no puede tener más de 200 caracteres");
        }

        if(course.getDescription() == null || course.getDescription().isEmpty()){
            throw new RuntimeException("La descripción del curso es obligatoria");
        }

        if(course.getDescription().length() > 150){
            throw new RuntimeException("La descripción del curso no puede tener más de 100 caracteres");
        }

        if(course.getPrice() == null || course.getPrice().isEmpty()){
            throw new RuntimeException("El precio del curso es obligatorio");
        }

        if(course.getPrice().length() > 6){
            throw new RuntimeException("El precio del curso no puede tener más de 6 caracteres");
        }

        if(course.getDuration() == null || course.getDuration().isEmpty()){
            throw new RuntimeException("La duración del curso es obligatoria");
        }

        if(course.getDuration().length() > 3) {
            throw new RuntimeException("La duración del curso no puede tener más de 3 caracteres");
        }

    }
}
