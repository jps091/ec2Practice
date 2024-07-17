package lecture.ec2.controller;

import lecture.ec2.model.User;
import lecture.ec2.service.Ec2Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final Ec2Service ec2Service;

    public UserController(Ec2Service ec2Service) {
        this.ec2Service = ec2Service;
    }

    @GetMapping("/ec2/metadata")
    public String getInstanceMetaData(){
        return ec2Service.getInstanceMetaData();
    }


    @GetMapping("/user/name")
    public String userCall(
            @RequestParam String name
    ){
        User user = new User(name);
        return "ec2 " + user.getName() + ": ";
    }
}
