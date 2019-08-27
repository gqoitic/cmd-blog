package com.gqoitic.cmd_blog.cmd_interface;

public enum Role {
    USER("[USER]"),
    ADMIN("[ADMIN]"),
    MODER("[MODER]");

    private String role;

    Role(String role){
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}
