package lecture.ec2.controller;

import lecture.ec2.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

/*    private final Ec2Service ec2Service;

    public UserController(Ec2Service ec2Service) {
        this.ec2Service = ec2Service;
    }

    @GetMapping("/ec2/metadata")
    public String getInstanceMetaData(){
        return ec2Service.getInstanceMetadata();
    }*/

    @GetMapping("/")
    public String Call(
    ){
        return "ec2 ";
    }

    public class OtherServerHealthIndicator {

        @GetMapping("/health")
        public ResponseEntity<String> health() {
            int httpStatus = 200; // 실제 로직으로 헬스 체크
            if (httpStatus == HttpStatus.OK.value()) {
                return new ResponseEntity<>("Healthy", HttpStatus.OK);
            }
            return new ResponseEntity<>("Unhealthy", HttpStatus.SERVICE_UNAVAILABLE);
        }
    }


    @GetMapping("/name")
    public String nameCall(
            @RequestParam String name
    ){
        User user = new User(name);
        return "ec2 " + user.getName() + ": ";
    }
}
