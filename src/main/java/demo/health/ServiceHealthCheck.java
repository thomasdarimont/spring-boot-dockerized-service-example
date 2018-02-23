package demo.health;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
class ServiceHealthCheck implements HealthIndicator{

    private volatile boolean healthy = true;

    @Override
    public Health health() {
        return healthy ? Health.up().build() : Health.down().build();
    }
}
