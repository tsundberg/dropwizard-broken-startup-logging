package se.organization.hag;

import com.codahale.metrics.health.HealthCheckRegistry;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Environment;
import org.junit.Test;
import se.organization.hag.Configuration;
import se.organization.hag.Main;
import se.organization.hag.greeting.GreetingResource;
import se.organization.hag.health.HealthCheck;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


public class MainTest {

    @Test
    public void should_get_name() {
        Main main = new Main();

        assertThat(main.getName()).isEqualTo("hello-world");
    }

    @Test
    public void should_register_hello_world_end_point() {
        Main main = new Main();

        Configuration configuration = mock(Configuration.class);

        Environment environment = mock(Environment.class);

        JerseyEnvironment jerseyEnvironment = mock(JerseyEnvironment.class);
        when(environment.jersey()).thenReturn(jerseyEnvironment);

        HealthCheckRegistry healthCheck = mock(HealthCheckRegistry.class);
        when(environment.healthChecks()).thenReturn(healthCheck);

        main.run(configuration, environment);

        verify(jerseyEnvironment).register(any(GreetingResource.class));
    }

    @Test
    public void should_register_hello_world_health_check() {
        Main main = new Main();

        Configuration configuration = mock(Configuration.class);

        Environment environment = mock(Environment.class);

        JerseyEnvironment jerseyEnvironment = mock(JerseyEnvironment.class);
        when(environment.jersey()).thenReturn(jerseyEnvironment);

        HealthCheckRegistry healthCheck = mock(HealthCheckRegistry.class);
        when(environment.healthChecks()).thenReturn(healthCheck);

        main.run(configuration, environment);

        verify(healthCheck).register(eq("template"), any(HealthCheck.class));
    }
}
