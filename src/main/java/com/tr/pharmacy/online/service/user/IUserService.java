package com.tr.pharmacy.online.service.user;


import com.tr.pharmacy.online.model.dto.UserDTO;
import com.tr.pharmacy.online.model.user.User;
import com.tr.pharmacy.online.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User>, UserDetailsService {
    User getByUsername(String username);

    Optional<User> findByUsername(String username);

    Optional<UserDTO> findUserDTOByUsername(String username);
}
