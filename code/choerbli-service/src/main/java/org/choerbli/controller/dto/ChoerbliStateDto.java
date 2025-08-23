package org.choerbli.controller.dto;

import lombok.Getter;

@Getter
public enum ChoerbliStateDto {
    VOTING(1),
    ASSIGNING(2),
    DONE(3);

    private final int state;

    ChoerbliStateDto(int state) {
        this.state = state;
    }

    public static ChoerbliStateDto fromState(int state) {
        for (ChoerbliStateDto s : values()) {
            if (s.state == state) {
                return s;
            }
        }

        throw new IllegalArgumentException("Unknown state: " + state);
    }
}
