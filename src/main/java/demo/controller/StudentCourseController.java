package demo.controller;
import demo.service.StudentCourseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Validated

public class StudentCourseController {

    private final StudentCourseService service;

    public StudentCourseController(StudentCourseService service) {
        this.service = service;
    }

    @PostMapping("/enroll")
    public String enroll(@RequestParam Long studentId,
                         @RequestParam Long courseId) {

        service.enrollStudentInCourse(studentId, courseId);
        return "Student enrolled successfully";
    }
}
