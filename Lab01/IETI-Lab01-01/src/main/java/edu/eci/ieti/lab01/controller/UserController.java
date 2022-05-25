package edu.eci.ieti.lab01.controller;

import edu.eci.ieti.lab01.data.User;
import edu.eci.ieti.lab01.dto.UserDto;
import edu.eci.ieti.lab01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/v1/user" )
public class UserController {
    private final UserService userService;

    public UserController (@Autowired UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        try{
            return ResponseEntity.ok().body(userService.getAll());
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id ) {
        try{
            return ResponseEntity.ok().body(userService.findById(id));
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }


    @PostMapping
    public ResponseEntity<User> create( @RequestBody UserDto userDto ) {
        try{
            User user = new User("", userDto.getName(), userDto.getEmail(), userDto.getLastName(), "");
            userService.Create(user);
            return ResponseEntity.ok().body(user);
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping( "/{id}" )
    public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id ) {
        try{
            User user = userService.findById(id);
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            user.setLastName(userDto.getLastName());
            userService.update(user, id);
            return ResponseEntity.ok().build();
        }
        catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<Boolean> delete( @PathVariable String id ) {
        try{
            userService.deleteById(id);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            return ResponseEntity.status(500).build();
        }
    }
}
