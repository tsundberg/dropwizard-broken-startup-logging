package se.organization.hag.greeting;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;
import se.organization.hag.greeting.Hello;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void should_serialize_to_json() throws Exception {
        Hello hello = new Hello(17, "Luther Blissett");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/saying.json"), Hello.class));

        assertThat(MAPPER.writeValueAsString(hello)).isEqualTo(expected);
    }

    @Test
    public void should_produce_a_readable_toString() {
        Hello hello = new Hello(17, "Luther Blissett");

        assertThat(hello.toString()).isEqualTo("Saying{id=17, content='Luther Blissett'}");
    }
}
