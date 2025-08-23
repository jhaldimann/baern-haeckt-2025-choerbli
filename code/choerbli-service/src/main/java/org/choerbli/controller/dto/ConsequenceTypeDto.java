package org.choerbli.controller.dto;

import lombok.Getter;

@Getter
public enum ConsequenceTypeDto {
    REWARD(1),
    PUNISHMENT(2);

    private final int type;

    ConsequenceTypeDto(int type) {
        this.type = type;
    }

    public static ConsequenceTypeDto fromType(int type) {
        for (ConsequenceTypeDto s : values()) {
            if (s.type == type) {
                return s;
            }
        }

        throw new IllegalArgumentException("Unknown type: " + type);
    }
}
