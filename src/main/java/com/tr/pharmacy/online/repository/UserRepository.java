package com.tr.pharmacy.online.repository;


import com.tr.pharmacy.online.model.dto.UserDTO;
import com.tr.pharmacy.online.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);

    Optional<User> findByUsername(String username);


    @Query("SELECT NEW com.tr.pharmacy.online.model.dto.UserDTO (" +
                "u.id, " +
                "u.username) " +
            "FROM User u WHERE u.username = ?1")
    Optional<UserDTO> findUserDTOByUsername(String username);

    @Query("SELECT NEW com.tr.pharmacy.online.model.dto.UserDTO (" +
                "u.id, " +
                "u.username," +
                "u.fullName," +
                "u.phoneNumber," +
                "u.address," +
                "u.role.code," +
                "u.createdAt, " +
                "u.deleted " +
            ") " +
            "FROM User u ")
    List<UserDTO> findAllUserDTO();

    Optional<User> findByIdAndDeletedFalse(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE User u " +
            "SET u.deleted = TRUE " +
            "WHERE u.id = :id")
    void blockUser(@Param("id") long id);

    @Modifying
    @Transactional
    @Query("UPDATE User u " +
            "SET u.deleted = FALSE " +
            "WHERE u.id = :id")
    void unblockUser(@Param("id") long id);
}
