package com.groweasy.coursesservice.repository;

import com.groweasy.coursesservice.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Course, Long> {

    Boolean existsByNameAndPrice(String name, String price);
}