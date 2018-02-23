package demo.health;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-health")
@RequiredArgsConstructor
class ServiceHealthCheckController {

    private final ServiceHealthCheck serviceHealthCheck;

    @PostMapping
    public void heal(){
        serviceHealthCheck.setHealthy(true);
    }

    @DeleteMapping
    public void hurt(){
        serviceHealthCheck.setHealthy(false);
    }
}
