package com.fpoly.myspringbootapp.dto.request;

import com.fpoly.myspringbootapp.dto.response.PermissionResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class RoleRequest {

    private String name;
    private String description;
    private Set<String> permissions;
}
