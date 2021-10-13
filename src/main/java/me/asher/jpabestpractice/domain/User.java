package me.asher.jpabestpractice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "users")
public class User {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column
    private String userName;

    @Column
    private String password;
}
