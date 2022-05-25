package org.ada.school.controller.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.ada.school.dto.LoginDto;
import org.ada.school.dto.TokenDto;
import org.ada.school.exception.InvalidCredentialsException;
import org.ada.school.model.Constants;
import org.ada.school.model.User;
import org.ada.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;

import static org.ada.school.model.Constants.CLAIMS_ROLES_KEY;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Value("${app.secret}")
    String secret;

    private final UserService userService;

    public AuthController (@Autowired UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public TokenDto login(@RequestBody LoginDto loginDto){
        User user = userService.findByEmail(loginDto.getEmail());
        if (BCrypt.checkpw(loginDto.getPassword(), user.getPasswordHash())){
            return generateTokenDto(user);
        }
        else{
            throw new InvalidCredentialsException();
        }
    }

    private TokenDto generateTokenDto (User user){
        Calendar expDate = Calendar.getInstance();
        expDate.add(Calendar.MINUTE, Constants.TOKEN_DURATION_MINUTES);
        String token = generateToken( user, expDate.getTime() );
        return new TokenDto( token, expDate.getTime() );
    }

    private String generateToken( User user, Date expirationDate )
    {
        return Jwts.builder()
                .setSubject( user.getId() )
                .claim( CLAIMS_ROLES_KEY, user.getRoles() )
                .setIssuedAt(new Date() )
                .setExpiration( expirationDate )
                .signWith( SignatureAlgorithm.HS256, secret )
                .compact();
    }
}
