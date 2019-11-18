package com.se.sample.manytomanydemo.entities.enums;

import java.util.stream.Stream;

public enum Priority {
    OPEN(10), REVIEW(20), APPROVED(30), REJECTED(40);

    private int priority;

    private Priority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public static Priority of(int priority) {
        return Stream.of(Priority.values())
                .filter(p -> p.getPriority() == priority)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
