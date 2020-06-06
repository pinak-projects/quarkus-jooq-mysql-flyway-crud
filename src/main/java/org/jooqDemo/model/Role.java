package org.jooqDemo.model;

import lombok.*;
import org.jooqDemo.constants.RoleType;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @NotNull
    private Integer roleId;

    @NotNull
    @Setter(AccessLevel.PRIVATE)
    private RoleType role;

}
