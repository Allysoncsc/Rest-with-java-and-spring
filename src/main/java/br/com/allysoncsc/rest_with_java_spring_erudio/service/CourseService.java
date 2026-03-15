package br.com.allysoncsc.rest_with_java_spring_erudio.service;

import br.com.allysoncsc.rest_with_java_spring_erudio.model.Course;
import br.com.allysoncsc.rest_with_java_spring_erudio.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public List<Course> findAll(){
        return courseRepository.findAll();
    }

    public Course create(Course course) {
        return courseRepository.save(course);
    }
}
