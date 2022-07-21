package com.tr.pharmacy.online.model.dto;

import com.tr.pharmacy.online.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserDTO {

    private Long id;

    @NotBlank(message = "Email address is required.")
    @Email(message = "The email address is invalid.")
    @Size(min = 5, max = 50, message = "The length of email must be between 5 and 50 characters.")
    private String username;

    @NotBlank(message = "Password is required.")
    @Size(min = 6, message = "Minimum password length is 6 characters.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$",
            message = "Password: Minimum six characters, at least one letter, one number and one special character:")
    private String password;

    @NotBlank(message = "Full name is required.")
    @Pattern(regexp = "[A-Za-z\\s]+", message = "Full name contains letters and whitespace only.")
    private String fullName;

    @NotBlank(message = "Phone number is required.")
    @Pattern(regexp = "^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$",
            message = "Incorrect phone number format. Correct format: +1 (608) 468-6527.")
    private String phoneNumber;

    private String address;

    private String roleName;

    private boolean deleted;

    @Valid
    private RoleDTO role;

    private String creationDate;

    public UserDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public UserDTO(Long id, String username, String fullName, String phoneNumber, String address, String roleName, Date creationDate, boolean deleted) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.roleName = roleName;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy 'at' hh:mm:ss a");
        this.creationDate = dateFormat.format(creationDate);
        this.deleted = deleted;
    }

    public User toUser() {
        return new User()
                .setId(id)
                .setUsername(username)
                .setPassword(password)
                .setFullName(fullName)
                .setPhoneNumber(phoneNumber)
                .setAddress(address)
                .setRole(role.toRole());
    }

}
