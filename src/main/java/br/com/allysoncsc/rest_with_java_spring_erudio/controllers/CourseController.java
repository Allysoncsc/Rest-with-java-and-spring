package br.com.allysoncsc.rest_with_java_spring_erudio.controllers;

import br.com.allysoncsc.rest_with_java_spring_erudio.model.Course;
import br.com.allysoncsc.rest_with_java_spring_erudio.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/findall")
    public List<Course> findAll(){
        return courseService.findAll();
    }

    @PostMapping("/create")
    public Course createCourse(@RequestBody Course course){return courseService.create(course);}

}
