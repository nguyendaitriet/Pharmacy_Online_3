package com.tr.pharmacy.online.repository;


import com.tr.pharmacy.online.model.dto.UserDTO;
import com.tr.pharmacy.online.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);

    Optional<User> findByUsername(String username);


    @Query("SELECT NEW com.tr.pharmacy.online.model.dto.UserDTO (u.id, u.username) FROM User u WHERE u.username = ?1")
    Optional<UserDTO> findUserDTOByUsername(String username);
}
