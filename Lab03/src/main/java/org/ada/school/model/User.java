package org.ada.school.model;

import org.ada.school.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document
public class User {

    @Id
    String id;

    String name;

    @Indexed( unique = true )
    String email;

    String lastName;

    String createdAt;

    private String passwordHash;

    private List<RoleEnum> roles;

    public User(){}

    public User( UserDto userDto ) {
        id = UUID.randomUUID().toString();
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        createdAt = new Date().toString();
        passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
    }

    public void update(UserDto userDto ) {
        name = userDto.getName();
        lastName = userDto.getLastName();
        email = userDto.getEmail();
        if (userDto.getPassword() != null) {
            this.passwordHash = BCrypt.hashpw(userDto.getPassword(), BCrypt.gensalt());
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPasswordHash() { return passwordHash; }

    public List<RoleEnum> getRoles() { return roles; }

}
