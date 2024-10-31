package com.groweasy.coursesservice.repository;

import com.groweasy.coursesservice.model.UserCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {
    List<UserCourse> findByUserId(Long userId);
}
