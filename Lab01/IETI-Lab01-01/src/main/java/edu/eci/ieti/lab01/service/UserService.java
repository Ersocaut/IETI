package edu.eci.ieti.lab01.service;

import edu.eci.ieti.lab01.data.User;

import java.util.List;

public interface UserService {
    User Create ( User user );

    User findById ( String id );

    List<User> getAll ();

    void deleteById ( String id );

    User update ( User user, String userId );
}
