package se.organization.hag.greeting;

import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.Rule;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreetingResourceTest {

    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new GreetingResource())
            .build();

    @Test
    public void get_one_thing() {
        Thingy thingy = new Thingy(1, null);

        Thingy actual = resources
                .target("/thingy/one")
                .request()
                .get(Thingy.class);

        assertThat(actual).isEqualTo(thingy);
    }

    @Test
    public void get_parent_and_child() {
        Thingy parent = new Thingy(1, "parent");
        Thingy child = new Thingy(2, "child");
        parent.add(child);

        Thingy actual = resources
                .target("/thingy/many")
                .request()
                .get(Thingy.class);

        assertThat(actual).isEqualTo(parent);
    }
}
