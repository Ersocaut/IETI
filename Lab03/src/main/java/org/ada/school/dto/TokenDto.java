package org.ada.school.dto;

import java.util.Date;

public class TokenDto {
    private String token;
    private Date expDate;

    public TokenDto ( String token, Date expDate ){
        this.token = token;
        this.expDate = expDate;
    }

    public String getToken() {
        return token;
    }

    public Date getExpDate() {
        return expDate;
    }
}
