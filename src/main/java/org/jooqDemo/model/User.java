package org.jooqDemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @NotNull
    private Integer userId;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String userName;

    @Getter(AccessLevel.PRIVATE)
    private boolean isDeleted = false;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotNull
    private Role role;
    private Date createdOn;
    private Date updatedOn;

    // utility method(s)

    public void setInitialTimestamps() {
        this.createdOn = new Date();
        this.updatedOn = new Date();
    }

}
