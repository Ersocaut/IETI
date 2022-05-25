package org.ada.school.repository;

import org.ada.school.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Map;

public interface UserRepository extends MongoRepository <User, String> {

    User findByEmail(String email);
}
