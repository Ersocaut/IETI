package org.ada.school.dto;

public class UserDto
{
    String name;
    String email;
    String lastName;
    String password;

    public UserDto(String name, String lastName, String email, String password){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPassword() { return password; }
}
