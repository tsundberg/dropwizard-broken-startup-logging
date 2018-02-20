package se.organization.hag.health;

public class HealthCheck extends com.codahale.metrics.health.HealthCheck {
    private final String template;

    public HealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() {
        final String saying = String.format(template, "TEST");
        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}