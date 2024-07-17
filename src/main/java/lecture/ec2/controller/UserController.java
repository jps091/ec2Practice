package lecture.ec2.controller;

import lecture.ec2.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("/user/name")
    public String userCall(
            @RequestParam String name
    ){
        User user = new User(name);
        return "ec2 " + user.getName() + ": ";
    }
}
