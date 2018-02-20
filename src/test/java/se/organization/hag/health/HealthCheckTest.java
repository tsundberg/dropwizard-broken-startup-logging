package se.organization.hag.health;

import com.codahale.metrics.health.HealthCheck.Result;
import org.junit.Test;
import se.organization.hag.health.HealthCheck;

import static org.assertj.core.api.Assertions.assertThat;

public class HealthCheckTest {

    @Test
    public void should_be_healthy() {
        HealthCheck healthCheck = new HealthCheck("Hello, %s!");

        Result result = healthCheck.check();

        assertThat(result.isHealthy()).isTrue();
    }

    @Test
    public void should_be_unhealthy() {
        HealthCheck healthCheck = new HealthCheck("Hello!");

        Result result = healthCheck.check();

        assertThat(result.isHealthy()).isFalse();
        assertThat(result.getMessage()).isEqualTo("template doesn't include a name");
    }
}
