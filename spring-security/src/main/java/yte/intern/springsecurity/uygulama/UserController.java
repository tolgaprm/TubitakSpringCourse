package yte.intern.springsecurity.uygulama;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public String user() {
        return "User Endpoint";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Admin Endpoint";
    }
}
