 package com.example.test.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.test.entities.Course;
import com.example.test.services.CourseService;

@RestController
public class MyController {
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/home")
public String home() {
	return "Welcome Home";
	 }
	                         // get course
	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourses(){
		List<Course> list = this.courseService.getCourses();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
		  return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
	}
	                        // get course by id
	@GetMapping("/courses/{courseId}")
	public ResponseEntity<Course> getCourse(@PathVariable String courseId) {
		Course course=this.courseService.getCourse(Long.parseLong(courseId));
		if(course==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return 
			ResponseEntity.of(Optional.of(course));
	
		}
	                        // enter course
   @PostMapping("/courses")
 
   public Course addCourse(@RequestBody Course course) {
	   return this.courseService.addCourse(course);
   } 
                           // delete course
   @DeleteMapping("/courses/{courseId}")
   public void deleteCourse(@PathVariable ("courseId") int courseId) {
	   this.courseService.deleteCourse(courseId);
   }
	                     // update course
   @PutMapping("/courses/{courseId}")
	public Course updateCourse(@RequestBody Course course,@PathVariable ("courseId") int courseId) {
		this.courseService.updateCourse(course, courseId);
		return course;
}
}



