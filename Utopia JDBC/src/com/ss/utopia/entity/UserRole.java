package com.ss.utopia.entity;

import java.util.Objects;

// UserRole entity with data fields
public class UserRole {
    private Integer roleID;
    private String name;

    public UserRole() {
    }

    public UserRole(Integer id, String name) {
        this.roleID = id;
        this.name = name;
    }

    public UserRole(int id) {
        this.roleID = id;
    }

    public Integer getRoleID() {
        return roleID;
    }

    public void setRoleID(Integer roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(roleID, userRole.roleID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleID);
    }
} // UserRole
