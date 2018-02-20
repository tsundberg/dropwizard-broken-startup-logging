package se.organization.hag.greeting;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Hello {
    private long id;

    private String content;

    public Hello() {
        // Jackson deserialization
    }

    Hello(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hello hello = (Hello) o;
        return id == hello.id &&
                Objects.equals(content, hello.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }

    @Override
    public String toString() {
        return "Saying{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}