package pers.ycy.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

    private String username;

    private String password;

    private String token;
}
