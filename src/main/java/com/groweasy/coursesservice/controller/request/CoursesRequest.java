package com.groweasy.coursesservice.controller.request;

import lombok.Data;

@Data
public class CoursesRequest {
    private String name;
    private String image;
    private String description;
    private String price;
    private String duration;
    private String category;
}
