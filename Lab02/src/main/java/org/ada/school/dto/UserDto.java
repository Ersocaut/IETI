package org.ada.school.dto;

public class UserDto
{
    String name;

    String email;

    String lastName;

    public UserDto(String name, String lastName, String email){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
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
}
