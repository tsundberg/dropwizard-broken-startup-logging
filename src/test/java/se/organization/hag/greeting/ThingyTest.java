package se.organization.hag.greeting;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

public class ThingyTest {
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    @Test
    public void should_serialize_to_json() throws Exception {
        Thingy thingy = new Thingy(17, "foo");

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/thingy.json"), Thingy.class));

        assertThat(MAPPER.writeValueAsString(thingy)).isEqualTo(expected);
    }

    @Test
    public void should_serialize_to_json_with_thingies() throws Exception {
        Thingy thingy = new Thingy(17, "parent");
        Thingy second = new Thingy(17, "child");
        thingy.add(second);

        final String expected = MAPPER.writeValueAsString(
                MAPPER.readValue(fixture("fixtures/two-thingies.json"), Thingy.class));

        assertThat(MAPPER.writeValueAsString(thingy)).isEqualTo(expected);
    }

    @Test
    public void should_produce_a_readable_toString() {
        Thingy thingy = new Thingy(17, "foo");

        assertThat(thingy.toString()).isEqualTo("{\n" +
                "  \"id\": 17,\n" +
                "  \"content\": \"foo\",\n" +
                "  \"thingies\": []\n" +
                "}");
    }
}
