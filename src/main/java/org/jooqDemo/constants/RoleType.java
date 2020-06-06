package org.jooqDemo.constants;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RoleType {

    @JsonProperty("Admin") ADMIN,
    @JsonProperty("User") USER
}
