package yte.intern.springweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

    @RequestMapping("/courses/{courseNumber}")
    public void course(
            @PathVariable int courseNumber,
            @RequestParam String name,
            @RequestParam String instructor
    ) {
        System.out.println(courseNumber + " " + name + " " + instructor);
    }
}
