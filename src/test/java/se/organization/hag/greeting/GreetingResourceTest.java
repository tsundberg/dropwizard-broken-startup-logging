package se.organization.hag.greeting;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Rule;
import org.junit.Test;
import se.organization.hag.greeting.GreetingResource;
import se.organization.hag.greeting.Hello;

import static org.assertj.core.api.Assertions.assertThat;

public class GreetingResourceTest {

    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new GreetingResource("Hello, %s!", "Thomas"))
            .build();

    @Test
    public void testGetPerson() {
        Hello hello = new Hello(1, "Hello, Thomas!");

        Hello actual = resources
                .target("/hello-world")
                .queryParam("name", "Thomas")
                .request()
                .get(Hello.class);

        assertThat(actual).isEqualTo(hello);
    }
}
