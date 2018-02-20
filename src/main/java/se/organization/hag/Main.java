package se.organization.hag;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import se.organization.hag.greeting.GreetingResource;
import se.organization.hag.health.HealthCheck;

public class Main extends Application<Configuration> {
    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
    }

    @Override
    public void run(Configuration configuration, Environment environment) {
        String template = configuration.getTemplate();
        String defaultName = configuration.getDefaultName();

        GreetingResource helloWorld = new GreetingResource(template, defaultName);
        environment.jersey().register(helloWorld);

        HealthCheck healthCheck = new HealthCheck(template);
        environment.healthChecks().register("template", healthCheck);
    }
}
