package com.groweasy.coursesservice.service.impl;

import com.groweasy.coursesservice.controller.request.CoursesRequest;
import com.groweasy.coursesservice.model.Course;
import com.groweasy.coursesservice.repository.CoursesRepository;
import com.groweasy.coursesservice.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;


    @Override
    public Course createCourse(CoursesRequest course) {
        Course courseToSave = new Course();
        courseToSave.setName(course.getName());
        courseToSave.setImage(course.getImage());
        courseToSave.setDescription(course.getDescription());
        courseToSave.setPrice(course.getPrice());
        courseToSave.setDuration(course.getDuration());
        courseToSave.setCategory(course.getCategory());
        return coursesRepository.save(courseToSave);
    }

    @Override
    public Course getCourseById(Long id) {
        return coursesRepository.findById(id).orElse(null);
    }
}
