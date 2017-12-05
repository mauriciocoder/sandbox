package com.bon.sand;

import java.util.Objects;
import java.util.Optional;

public abstract class Person {
    private String name;

    public Person(String name) {
        Objects.requireNonNull(name, "Name must not be null!!!");
        this.name = name;
    }

    public abstract String shout();

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }
}
