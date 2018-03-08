package se.organization.hag.greeting;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Thingy {
    private long id;
    private String content;
    private List<Thingy> thingies;

    public Thingy() {
        // Jackson deserialization
    }

    Thingy(long id, String content) {
        this.id = id;
        this.content = content;
        thingies = new ArrayList<>();
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    @JsonProperty
    public List<Thingy> getThingies() {
        return thingies;
    }

    public void add(Thingy thingy) {
        thingies.add(thingy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thingy thingy = (Thingy) o;
        return id == thingy.id &&
                Objects.equals(content, thingy.content) &&
                Objects.equals(thingies, thingy.thingies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, thingies);
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"id\": " + id +",\n"+
                "  \"content\": \"" + content + "\"" +",\n"+
                "  \"thingies\": " + thingies +"\n"+
                '}';
    }
}