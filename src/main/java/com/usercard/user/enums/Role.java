package com.usercard.user.enums;

public class Role implements GrantedAuthority{
    ADMIN("ADMIN"),
    USER("USER");

    private final String vale;

    @Override
    public String getAuthority() {
        return vale;
    }
}
