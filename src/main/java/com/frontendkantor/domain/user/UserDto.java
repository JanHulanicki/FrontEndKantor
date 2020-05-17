package com.frontendkantor.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private Long id;
    private String nick;
    private String password;
    private String emailAddress;
    private String name;
    private String surname;
    private Boolean isBlocked;
    private String uuidKey;
    private LocalDateTime expiredDate;

    public UserDto(String nick, String password, String emailAddress, String name, String surname, Boolean isBlocked, String uuidKey, LocalDateTime expiredDate) {
        this.nick = nick;
        this.password = password;
        this.emailAddress = emailAddress;
        this.name = name;
        this.surname = surname;
        this.isBlocked = isBlocked;
        this.uuidKey = uuidKey;
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", isBlocked=" + isBlocked +
                ", uuidKey='" + uuidKey + '\'' +
                ", expiredDate=" + expiredDate +
                '}';
    }
}