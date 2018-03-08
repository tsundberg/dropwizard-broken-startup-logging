package se.organization.hag.greeting;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("thingy")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {
    private final AtomicLong counter;

    public GreetingResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    @Path("one")
    public Thingy getThingy() {
        return new Thingy(counter.incrementAndGet(), null);
    }

    @GET
    @Timed
    @Path("many")
    public Thingy getNestedThingy() {
        Thingy parent = new Thingy(counter.incrementAndGet(), "parent");

        Thingy second = new Thingy(counter.incrementAndGet(), "child");
        parent.add(second);

        return parent;
    }
}
