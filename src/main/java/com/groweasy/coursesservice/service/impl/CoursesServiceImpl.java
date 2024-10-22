package com.groweasy.coursesservice.service.impl;

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
    public Course createCourse(Course course) {
        return coursesRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return coursesRepository.findById(id).orElse(null);
    }
}
