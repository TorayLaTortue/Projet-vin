package com.example.StockOvin.Entities;

public enum RoleEntity {
    USER("user"),
    ADMIN("admin"),
    SUPPLIER("supplier");

    private String role;

    RoleEntity(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public static String findRole(String role) {
        for (RoleEntity roleEntity : RoleEntity.values()) {
            if (roleEntity.getRole().equalsIgnoreCase(role)) {
                return roleEntity.role;
            }
        }
        throw new IllegalArgumentException("No enum constant with role " + role);
    }
}
