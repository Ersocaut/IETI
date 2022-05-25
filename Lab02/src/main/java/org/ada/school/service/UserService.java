package org.ada.school.service;

import org.ada.school.dto.*;
import org.ada.school.model.User;

import java.util.List;

public interface UserService
{
    User create( User user );

    User findById( String id );

    List<User> getAll();

    boolean deleteById( String id );

    User update( UserDto userDto, String id );
}
