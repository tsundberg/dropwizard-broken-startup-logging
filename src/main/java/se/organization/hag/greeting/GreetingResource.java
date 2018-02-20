package se.organization.hag.greeting;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {
    private String template;
    private final String defaultName;
    private final AtomicLong counter;

    public GreetingResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    @GET
    @Timed
    public Hello sayHello(@QueryParam("name") Optional<String> name) {
        String value = String.format(template, name.orElse(defaultName));
        return new Hello(counter.incrementAndGet(), value);
    }
}
