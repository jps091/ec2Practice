package lecture.ec2.utils;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class OtherServerHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int httpStatus = 200; // 여기서 서버로 ping을 날리든, health api를 호출하든 응답을 받는다.
        if (httpStatus == HttpStatus.OK.value()) {
            return Health.up().build();
        }

        return Health.down().build();
    }
}
