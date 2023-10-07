package yte.intern.springweb.valid;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @PostMapping("/user")
    public void addUser(@RequestBody @Valid User user) {

    }
}