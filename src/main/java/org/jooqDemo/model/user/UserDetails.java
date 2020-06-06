package org.jooqDemo.model.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jooqDemo.constants.APIConstants;
import org.jooqDemo.model.Role;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(APIConstants.ROLE_ID)
public class UserDetails extends User {

    @NotNull
    private Role role;

    public String getFullName() {
        return new StringBuilder().append(getFirstName()).append(APIConstants.BLANK_QUOTE).append(getLastName()).toString();
    }
}
