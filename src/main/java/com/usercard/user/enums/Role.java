package com.usercard.user.enums;

import lombok.*;

@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum Role {
    ADMIN("ADMIN"),
    USER("USER");

    private final String value;

}
