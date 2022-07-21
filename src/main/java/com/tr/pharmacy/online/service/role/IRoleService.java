package com.tr.pharmacy.online.service.role;


import com.tr.pharmacy.online.model.user.Role;
import com.tr.pharmacy.online.service.IGeneralService;

public interface IRoleService extends IGeneralService<Role> {
    Role findByName(String name);
}
