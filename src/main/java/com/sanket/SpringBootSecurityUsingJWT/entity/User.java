package com.sanket.SpringBootSecurityUsingJWT.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_tbl")
public class User {
    @Id
    private int id;
    private String userName;
    private String password;
    private String email;
}
