package com.tr.pharmacy.online.model.dto;

import com.tr.pharmacy.online.model.user.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RoleDTO {

    @NotNull(message = "Role ID is required.")
    private Long id;

    private String code;

    public Role toRole() {
        return new Role()
                .setId(id)
                .setCode(code);
    }

}
